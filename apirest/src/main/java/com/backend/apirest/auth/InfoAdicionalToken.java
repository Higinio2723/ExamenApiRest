package com.backend.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import com.backend.apirest.models.users.UserEntity;
import com.backend.apirest.models.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	IUserService usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UserEntity usuario = usuarioService.findByUsername(authentication.getName());
		
		Map<String,Object> info = new HashMap<>();
		info.put("info_adicional","Hola que tal ".concat(authentication.getName()));	
		info.put("name_usuario", usuario.getId() +" - "+ usuario.getUsername());
		
		info.put("nombre", usuario.getNombre());
		info.put("apellido", usuario.getApellido());
		info.put("email", usuario.getEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);	
 		
		return accessToken;
	}

}
