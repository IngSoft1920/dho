package ingsoft1920.dho.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.dho.DAO.ClienteDAO;
import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.ProductosDAO;
import ingsoft1920.dho.DAO.ProveedoresDAO;
import ingsoft1920.dho.bean.ClienteBean;
import ingsoft1920.dho.bean.ProductosBean;
import ingsoft1920.dho.bean.ProveedoresBean;

public class pedirProveedores {
	/*
	 * [ { "proveedor_id": 1,"empresa":"abc", "productos": [ { "id": 10, "nombre": "tomates",
	 * "precio_venta": 300, "unidad_medida": "tonelada" }, { "id": 11, "nombre":
	 * "lechuga", "precio_venta": 10, "unidad_medida": "kilo" } ] }, {
	 * "proveedor_id": 3,"empresa":"cde", "productos": [ { "id": 20, "nombre": "vino",
	 * "precio_venta": 40, "unidad_medida": "litro" }, { "id": 21, "nombre": "ron",
	 * "precio_venta": 80, "unidad_medida": "litro" }, { "id": 21, "nombre": "ron",
	 * "precio_venta": 80, "unidad_medida": "litro" } ] } ]
	 */

	public static ClienteBean pedirProveedores(int hotel_id) {
		try {
			// construimos la peticion
			HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/hotel-proveedores/" + hotel_id,
					"GET");

			int respCode = client.getResponseCode();
			if (respCode == 200) {
				String resp = client.getResponseBody();
				JsonArray obj = (JsonArray) JsonParser.parseString(resp);
				for (int i = 0; i < obj.size(); i++) {
					JsonObject aux = obj.get(i).getAsJsonObject();
					int proveedor_id = aux.get("proveedor_id").getAsInt();
					String empresa=aux.get("empresa").getAsString();
					ProveedoresBean proveedor=new ProveedoresBean(proveedor_id,empresa,hotel_id);
					ProveedoresDAO.anadirProveedor(proveedor);
					JsonArray productos = aux.get("productos").getAsJsonArray();
					for (int j= 0;j<productos.size();j++) {
						JsonObject productosAux=productos.get(j).getAsJsonObject();
						int id = productosAux.get("id").getAsInt();
						String nombre = productosAux.get("nombre").getAsString();
						int precio_venta = productosAux.get("precio_venta").getAsInt();
						String unidad_medida = productosAux.get("unidad_medida").getAsString();
						ProductosBean producto=new ProductosBean(id,nombre,precio_venta,proveedor_id,unidad_medida);
						ProductosDAO.anadirProducto(producto);
						
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
