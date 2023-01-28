package com.backend.apirest.auth;

public class JwtConfig {

	public static final String LLAVE_SECRETA="alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVATE="-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpQIBAAKCAQEAtWZOSXGt5KBw2dexHEjjY+REGr7l5iyhQc+84aE+5dSuHuZ/\r\n" + 
			"0sSnudYYOdLSRQPcRdl96K9mLFC/eMy/yGznsdQh5/etafljTJN9kPIS0VXSvRrE\r\n" + 
			"OB0qukmeVnrh6EDrujyre4GX6x6NJx3DP2eL58FkzcYD3sYvpEnJKmtbHc8pdhd9\r\n" + 
			"7I5Kg3VrBvrvtUc5EE+MSCkQ5GBxIAof1kNrRKw4gzYCjUPJhxjTCNGVslvqIew6\r\n" + 
			"UDltWKkxe/W+JCBvDh0A3aaFg/uYW1lun8aepC3VW3TxY6+Jav6+IoYVGHW9KpVX\r\n" + 
			"hJwcH0Ve+zo4xuhllJPiopXGUHWjHayQBkoUdQIDAQABAoIBADrgPLKbwfv9kwMx\r\n" + 
			"fZuXkK5ATVZ89TNS8vfgTAbThg2kjOsclwo6p9GqSmyiH3sk+J53K+WU4E2r26mC\r\n" + 
			"kxCjQEQ4fNTET7WgqvkUueGMoEzvVRnpkRxBYzfZYxnggmgWgiwNOv84Ha3DWb8D\r\n" + 
			"avauTftniqc7CNCKdLYW+MLa21T99o/hLaQDl7Mc5tw7rRTSBCQkxtVzUaAM7pyt\r\n" + 
			"BUdOmXiI/J9NBlVhsBZnKVwTDOJUBTMx7fivdH9KDm2wFGSv0txfa3uLdHgTnSjz\r\n" + 
			"Mrz76xzrYboJMzP1+708VvjTo30srv0/ePMcpYNNsiUbbF5CTIDV9k4m4V6iXkUO\r\n" + 
			"hdiBsDUCgYEA7KeukdD76n1Hm9Iv+xgMZ1F00y/td8MFYwOIpZ3Ac5xWCAh1eOJN\r\n" + 
			"nNir9sqToO0dFFfiJbPQnPt/S31/AIt9rgzLb0FA2QkKPZY3fdnTAhfRsn2REYUK\r\n" + 
			"d2ijq+pxvTtgF0CeKppBlzr96pOglyhC/s2XFZUKWHfLBvEgmQRFdz8CgYEAxDpV\r\n" + 
			"Ee6Rye/oGh+d0eMCK5YLTBblIvoEn2R+FYTBfiYfalpn5CGaoSHseNeEVpmMAqEw\r\n" + 
			"wnCDFaEenOIpvRf0Aj7TtO8/fGrc4UGYkBey1kuCK+yZFckKGN3aJeHspb7Teg8B\r\n" + 
			"E/i3ZiR44LMQ2JBmhUXVIaJ6QrruQsiiH28Dm0sCgYEAhGewwP6W43Qia2jm1Wp4\r\n" + 
			"DhpB7aKEDxx62BHzEw42zbgrXiU1bGPZHqcPV22xuTjQq0AcVBHN5vbDGr5lHy3s\r\n" + 
			"LEQWUfHFUWjAZQK1m2ESsLoY5e9hCddQqsxNvnLWHhSpR3ksxRM3HWCxDdx43fl1\r\n" + 
			"uk/WdwnDFwo2+nRQU6xTHUsCgYEAuGILf58JdJOuJ6XfuNGzP1ts4CF/S39cip11\r\n" + 
			"8ChfXHbb/CZZCr8cuh3TQrVYD7uWGP53f60TL2bHCilliN4SFW4Npi1NHU6YoDzv\r\n" + 
			"6y2piL1I4pcePZ87kqQcEI6avB90PXQN0kNZqWvJ/XGk+amt+7rjiwhOE5fsu+ok\r\n" + 
			"lJ7O58MCgYEAxzqRdcAegJTmOTIfWLVpERVyvNlPLtGkuVgTMDmjmJVgUKiWfCSG\r\n" + 
			"OwqzZ1c53Necbt/Y3zUH3CogMyCgK21jZw4QLhlLTeTgvvDFfqy5VYKvTdil/h0i\r\n" + 
			"XoQGw/SvwGa7D2JYlolJ9N+caSk9tKNaU9Ex8dt9s32I+m/iVRaa4x8=\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA="-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtWZOSXGt5KBw2dexHEjj\r\n" + 
			"Y+REGr7l5iyhQc+84aE+5dSuHuZ/0sSnudYYOdLSRQPcRdl96K9mLFC/eMy/yGzn\r\n" + 
			"sdQh5/etafljTJN9kPIS0VXSvRrEOB0qukmeVnrh6EDrujyre4GX6x6NJx3DP2eL\r\n" + 
			"58FkzcYD3sYvpEnJKmtbHc8pdhd97I5Kg3VrBvrvtUc5EE+MSCkQ5GBxIAof1kNr\r\n" + 
			"RKw4gzYCjUPJhxjTCNGVslvqIew6UDltWKkxe/W+JCBvDh0A3aaFg/uYW1lun8ae\r\n" + 
			"pC3VW3TxY6+Jav6+IoYVGHW9KpVXhJwcH0Ve+zo4xuhllJPiopXGUHWjHayQBkoU\r\n" + 
			"dQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
