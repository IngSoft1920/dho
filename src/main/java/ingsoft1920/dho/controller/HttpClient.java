package ingsoft1920.dho.controller; 
 
	import java.io.BufferedReader; 
	import java.io.InputStreamReader; 
	import java.io.OutputStream; 
	import java.net.HttpURLConnection; 
	import java.net.URL; 
	import org.apache.logging.log4j.LogManager; 
	import org.apache.logging.log4j.Logger; 
	public class HttpClient { 
		final static Logger logger = LogManager.getLogger(HttpClient.class.getName()); 
		URL url; 
		HttpURLConnection con; 
		String method; 
		/* 
		 * Flujo de ejecucion: 
		 * 1. Instancio esta clase 
		 * 	HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/getLoQueSea"); 
		 * 2. Establzco el cuerpo de la peticion 
		 * 	client.setRequestBody(cuerpoDeLaPeticionEnJson); 
		 * 3. Envio y obtengo codigo respuesta 
		 * 	int respCode = client.getResponseCode(); 
		 * 4. Si resp ok->200, obtengo cuerpo de respuesta 
		 * 	if(respCode==200){ 
		 * 		String resp=client.getResponseBody(); 
		 * 		//tratamiento del JSON como tengais que hacerlo 
		 * 	} 
		 */ 
		//Constructor: hay que poner la ruta en url1 y el metodo (POST; GET...) en method 
		public HttpClient(String url1, String method) throws Exception { 
			try { 
				this.url = new URL(url1); 
				con = (HttpURLConnection) this.url.openConnection(); 
				con.setRequestMethod(method); 
				this.method=method; 
				con.setRequestProperty("Content-Type", "application/json; utf-8"); 
				con.setRequestProperty("Accept", "application/json"); 
			}catch(Exception ex) { 
				logger.error("Error al inicializar la peticion",ex); 
				throw ex; 
			} 
		} 
		//Envia la peticion y obtiene el codigo de la respuesta como int (200->OK; 404->Not found...) 
		public int getResponseCode() throws Exception { 
			logger.info("Realizando peticion y obteniendo codigo de respuesta"); 
			try { 
				return this.con.getResponseCode(); 
			} catch (Exception ex) { 
				logger.error("Error al enviar la peticion",ex); 
				throw ex; 
			} 
		} 
		//Obtiene el cuerpo de la respeusta como string. 
		public String getResponseBody() throws Exception { 
			logger.info("Obteniendo el cuerpo de la respuesta"); 
			try { 
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
				String inputLine; 
				StringBuffer content = new StringBuffer(); 
				while ((inputLine = in.readLine()) != null) { 
					content.append(inputLine); 
				} 
				in.close(); 
				logger.debug("Cuerpo de la respuesta: \n"+content.toString()); 
				return content.toString(); 
			}catch(Exception ex) { 
				logger.error("Error al leer cuerpo de la peticion",ex); 
				throw ex; 
			} 
		} 
		public String getUrlasString() { 
			return this.url.toString(); 
		} 
		//Esatblece el cuerpo de la peticion como string 
		public void setRequestBody(String body) { 
			con.setDoOutput(true); 
			try(OutputStream os = con.getOutputStream()) { 
			    byte[] input = body.getBytes("utf-8"); 
			    os.write(input, 0, input.length); 
			    con.setRequestMethod(this.method); 
			}catch(Exception ex) { 
			} 
			logger.info("Estableciendo cuerpo de peticion"); 
			logger.debug("Cuerpo de la peticion: \n"+body); 
		} 
	} 
	 
	 
