package br.com.gds.parser;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.gds.model.Modelo;

public class parserXmlTest {

	@Test
	public void efetuaParseObjToXmlTest() {
		
		// recupera xml a partir de objeto;
		Modelo modelo = new Modelo();
		modelo.setNome("Gustavo");
		modelo.setEndereco("Rua xxx, numero 10");
		modelo.setTelefone("11-96311-7022");
		modelo.setEmail("gdinsantos1@gmail.com");
		
		XStream xst  = new XStream();
		xst.alias("modelo", Modelo.class);
		
		String xml = xst.toXML(modelo);
		
		Assert.assertTrue(xml.contains("<modelo>"));
		Assert.assertTrue(xml.contains("<nome>Gustavo</nome>"));
		Assert.assertTrue(xml.contains("<endereco>Rua xxx, numero 10</endereco>"));
		Assert.assertTrue(xml.contains("<telefone>11-96311-7022</telefone>"));
		Assert.assertTrue(xml.contains("<email>gdinsantos1@gmail.com</email>"));
		Assert.assertTrue(xml.contains("</modelo>"));
	}
	
	@Test
	public void efetuaParseXmlToObjTest() {
		String xml = "<modelo><nome>Gustavo</nome><endereco>Rua xxx, numero 10</endereco><telefone>11-96311-7022</telefone><email>gdinsantos1@gmail.com</email></modelo>";

		XStream xst = new XStream();
		
		// registre o alias para que o framework possa converter o <modelo> para br.com.gds.model.Modelo
		xst.alias("modelo", Modelo.class);
		
		Modelo modelo = (Modelo) xst.fromXML(xml);
		
		Assert.assertTrue(modelo.getNome().equals("Gustavo"));
		Assert.assertTrue(modelo.getEndereco().equals("Rua xxx, numero 10"));
		Assert.assertTrue(modelo.getTelefone().equals("11-96311-7022"));
		Assert.assertTrue(modelo.getEmail().equals("gdinsantos1@gmail.com"));
	}
	
	@Test
	public void efetuaParseObjToJsonTest() {
		// recupera xml a partir de objeto;
		Modelo modelo = new Modelo();
		modelo.setNome("Gustavo");
		modelo.setEndereco("Rua xxx, numero 10");
		modelo.setTelefone("11-96311-7022");
		modelo.setEmail("gdinsantos1@gmail.com");
		
		Gson gson = new Gson();
		String json = gson.toJson(modelo);
		
		Assert.assertTrue(json.contains("\"nome\":\"Gustavo\""));
		Assert.assertTrue(json.contains("\"endereco\":\"Rua xxx, numero 10\""));
		Assert.assertTrue(json.contains("\"telefone\":\"11-96311-7022\""));
		Assert.assertTrue(json.contains("\"email\":\"gdinsantos1@gmail.com\""));
		
	}
	
	@Test
	public void efetuaParseJsonToObjTest() {
		String json = "{\"nome\":\"Gustavo\",\"endereco\":\"Rua xxx, numero 10\",\"telefone\":\"11-96311-7022\",\"email\":\"gdinsantos1@gmail.com\"}";
		Gson gson = new Gson();
		
		Modelo modelo = gson.fromJson(json, Modelo.class);
	
		Assert.assertTrue(modelo.getNome().equals("Gustavo"));
		Assert.assertTrue(modelo.getEndereco().equals("Rua xxx, numero 10"));
		Assert.assertTrue(modelo.getTelefone().equals("11-96311-7022"));
		Assert.assertTrue(modelo.getEmail().equals("gdinsantos1@gmail.com"));
	}
	
	
}
