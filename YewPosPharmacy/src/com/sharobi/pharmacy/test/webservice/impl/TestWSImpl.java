package com.sharobi.pharmacy.test.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.inventory.model.CountryMaster;
import com.sharobi.pharmacy.test.service.TestService;

@Path(value="/testing")
public class TestWSImpl {
	
	//@Autowired
	private TestService testservice = new TestService();
	
	@Path(value = "/tset")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String testing() {
		System.out.println("Testing url : /rest/testing/tset");
		ResponseObj responseObj = new ResponseObj();
		responseObj.setId(1);
		responseObj.setStatus("Success");
		responseObj.setReason("Testing");
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		
		//System.out.println("time diff in WS:: " + (endTime - startTime));
	

		return json;
	}
	
	@Path(value = "/getaccgroup")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public List<CountryMaster> getaccgroup() {
		List<CountryMaster> acdts = new ArrayList<CountryMaster>();
		
		acdts = testservice.getAllaccgroups();
		
		return acdts;
		/*Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(acdts, CountryMaster.class);
		
		//System.out.println("time diff in WS:: " + (endTime - startTime));

		return json;*/
	}
	
	@Path(value = "/getspeccntris")
	@POST
	/*@Consumes("application/json")
	@Produces("application/json")*/
	public @ResponseBody List<CountryMaster> getspecCountries(@RequestBody CountryMaster cm) {
		System.out.println("cm = "+cm);
		List<CountryMaster> acdts = new ArrayList<CountryMaster>();
		
		acdts = testservice.getspeccntris(cm);
		
		return acdts;
		/*Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(acdts, CountryMaster.class);
		
		//System.out.println("time diff in WS:: " + (endTime - startTime));

		return json;*/
	}
	
	@Path(value = "/testmenu")
	@GET
	/*@Consumes("application/json")
	@Produces("application/json")*/
	public @ResponseBody Mod testmenu() {
		
//		Mod m = new Mod(0,"root",-1);
		Mod m = getMods().get(0);
		return genMod(m);
		
	}
	
	public List<Mod> getMods()
	{
		List<Mod> mods = new ArrayList<>();
		
		mods.add(new Mod(0,"root",-1));
		mods.add(new Mod(1,"1",0));
		mods.add(new Mod(2,"2",1));
		mods.add(new Mod(3,"3",1));
		mods.add(new Mod(4,"4",1));
		mods.add(new Mod(5,"5",0));
		mods.add(new Mod(6,"6",5));
		mods.add(new Mod(7,"7",5));
		mods.add(new Mod(8,"8",5));
		mods.add(new Mod(9,"9",0));
		mods.add(new Mod(10,"10",6));
		mods.add(new Mod(11,"11",6));
		
		return mods;
	}
	
	public Mod genMod(Mod m)
	{
		List<Mod> all = getMods();
		Mod genM = new Mod();
		for (Mod mod : all) {
			List<Mod> ch = getModChildren(m.getId());
			if(ch.size()>0)
			{
				m.setChildren(ch);
				for (Mod mod2 : ch) {
					genMod(mod2);
				}
			}
			
		}
		genM = m;
		System.out.println("GenM = "+genM);
		return genM;
	}
	
	public List<Mod> getModChildren(int id)
	{
		List<Mod> all = getMods();
		List<Mod> children = new ArrayList<>();
		for (Mod mod : all) {
			if(mod.getParent()==id)
			{
				children.add(mod);
			}
		}
		return children;
	}
	
	
	class Mod {
		int id;
		String name;
		int parent;
		List<Mod> children;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getParent() {
			return parent;
		}
		public void setParent(int parent) {
			this.parent = parent;
		}
		public List<Mod> getChildren() {
			return children;
		}
		public void setChildren(List<Mod> children) {
			this.children = children;
		}
		
		public Mod() {
			// TODO Auto-generated constructor stub
		}
		public Mod(int id, String name, int parent) {
			super();
			this.id = id;
			this.name = name;
			this.parent = parent;
		}
		@Override
		public String toString() {
			return "Mod [id=" + id + ", name=" + name + ", parent=" + parent + ", children=" + children + "]";
		}
		
	}
	
}
