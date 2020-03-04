package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.Data;
import service.PDataService;

@RestController

public class PDataController {
	  PDataService dataService=new PDataService();;
	 @RequestMapping(value = "/insert",method = RequestMethod.GET)
	    public String insert(@RequestParam int id,@RequestParam Double lon,@RequestParam Double lat){
	        System.out.println("开始插入点。。。。。。。。");
	        return dataService.insert(id, lat, lon);
	    }
	 @RequestMapping(value = "/get1",method = RequestMethod.GET)
	 public List<Data> getLi1(@RequestParam double minX,@RequestParam double minY,@RequestParam double maxX,@RequestParam double maxY){
		 System.out.println("开始查询点。。。。。。。。");
	        return dataService.getList1(minX, minY, maxX, maxY);
	 }
	 @RequestMapping(value = "/get2",method = RequestMethod.GET)
	 public List<Data> getLi2(@RequestParam String hash1,@RequestParam String hash2){
		 System.out.println("开始查询点。。。。。。。。");
	        return dataService.getList2(hash1);
	 }
}
