package com.backend.apirest.models.report;

import com.backend.apirest.models.ratings.RatingsService;
import com.backend.apirest.models.ratings.dto.RatingDto;
import com.backend.apirest.util.ValidationUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReportController {

	private final Logger logger = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	RatingsService ratingsService;


	@GetMapping("/report/student")
	public ResponseEntity<byte[]> getRecordReport(@RequestParam(name = "idStudent" , required = false)  Integer idStudent) {

		try {
			List<RatingDto> ratings = null;

			if(idStudent != null){
				ratings = ratingsService.findByIdStudent(idStudent);
			}else{
				ratings = ratingsService.findByAll();
			}

			double  average = ValidationUtils.getAverage(ratings);
			logger.info("####################### average {}",average);

			//dynamic parameters required for report
			Map<String, Object> calParams = new HashMap<String, Object>();
			calParams.put("CompanyName", "Universidad");
			calParams.put("calificacionesData", new JRBeanCollectionDataSource(ratings));
			calParams.put("promedio", average);

			JasperPrint empReport =
					JasperFillManager.fillReport
				   (
							JasperCompileManager.compileReport(
							ResourceUtils.getFile("classpath:calificaciones-details.jrxml")
									.getAbsolutePath()) // path of the jasper report
							, calParams // dynamic parameters
							, new JREmptyDataSource()
					);
			
			HttpHeaders headers = new HttpHeaders();
			//set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "calificaciones-details.pdf");
			//create the report in PDF format
			return new ResponseEntity<byte[]>
					(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
			
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
