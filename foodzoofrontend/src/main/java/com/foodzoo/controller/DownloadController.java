package com.foodzoo.controller;

import org.springframework.stereotype.Controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @author Parul.Sharma
 *controller annotation for making this class as controller class
 *DownloadController class for fetching images dynamically from the folder
 */
@Controller
public class DownloadController {
	/**
	 * file loaction tells the location of the file where images are stored
	 */
	private final String fileLocation = "/Users/Abhinandan.Gupta/Desktop/Projects/FoodProducts/";
/**
 * for keeping the log of all transactions
 */
	private final static Logger LOGGER = LogManager.getLogger(DownloadController.class);
/**
 * requestmapping for download wherever it finds downloads action this will run
 * download the file with that product id and fetch it and sh
 * @param id
 * @return
 * @throws IOException
 */
	@RequestMapping(value = "download", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	@ResponseBody
	public byte[] downloadFile(@RequestParam("productId") String id) throws IOException {
	InputStream inputStream = new FileInputStream(fileLocation+ id+".jpg");
	return IOUtils.toByteArray(inputStream);
	}
	
}
