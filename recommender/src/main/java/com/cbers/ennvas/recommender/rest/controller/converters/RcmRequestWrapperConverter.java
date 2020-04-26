package com.cbers.ennvas.recommender.rest.controller.converters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.StringWriter;

import com.cbers.ennvas.recommender.rest.controller.data.RcmRequestWrapper;

//import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;


/**
 * Debe convertir de un objeto JSON como el siguiente a un objeto
 * RcmInputWrapper con sus dos campos Query y Knowledgebase:
 * 
 	{
		query: {
			phrase: "...",
			priceMin: "...",
			priceMax: "...",
			freeShipping: "...",
			maxShippingTime: "...",
			available: "...",
			minRatin: "..."
		},
		knowledgebase: [
			{
				name: "...",
				type: "...",
				brand: "...",
				price: "...",
				shippingPrice: "...",
				shippingTime: "...",
				stock: "...",
				description: "...",
				rating: "..."
			},
			{
				...
			},
			{
				...
			},
			...
		]
	}
 */


public class RcmRequestWrapperConverter extends AbstractHttpMessageConverter<RcmRequestWrapper> {

	public RcmRequestWrapperConverter()
	{
		super(MediaType.APPLICATION_JSON);
	}

	/**
	 * Used to determine whether the converter actually supports conversion to 
	 * and from the type of object in question. 
	 * 
	 * We’ll simply return true and support any object.
	 */
	@Override
	protected boolean supports(Class<?> clazz)
	{
		return clazz.getName() == RcmRequestWrapper.class.getName();
	}

	/**
	 * Abstract template method that reads the actual object. This describes 
	 * how Spring should convert the JSON String into a Java object.
	 * 
	 * Invoked from read(java.lang.Class<? extends T>, org.springframework.http.
	 * HttpInputMessage).
	 * 
	 * @param clazz - the type of object to return
     * @param inputMessage - the HTTP input message to read from
	 * 
	 * @return the converted object
	 * 
	 * @throws IOException - in case of I/O errors
     * @throws HttpMessageNotReadableException - in case of conversion errors 
	 */
	@Override
	protected RcmRequestWrapper readInternal(Class<? extends RcmRequestWrapper> clazz, HttpInputMessage inputMessage)
		throws IOException, HttpMessageNotReadableException
	{

		
		
		//creating an InputStreamReader object
		InputStreamReader isReader = new InputStreamReader(inputMessage.getBody());
		//Creating a BufferedReader object
		BufferedReader reader = new BufferedReader(isReader);
		StringBuffer sb = new StringBuffer();
		String str;
		while((str = reader.readLine())!= null){
		   sb.append(str);
		}
		System.out.println("#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n#\n");
		System.out.println(sb.toString());



		
		//System.out.println(inputMessage.getBody().);
		return null;

	}

	/**
	 * Abstract template method that writes the actual body. Generates a JSON 
	 * String from a Java Object.
	 * 
	 * Invoked from write(T, org.springframework.http.MediaType, org.
	 * springframework.http.HttpOutputMessage).
	 * 
	 * @param t - the object to write to the output message
	 * @param outputMessage - the HTTP output message to write to
	 * 
	 * @throws IOException - in case of I/O errors
	 * @throws HttpMessageNotWritableException - in case of conversion errors 
	 */
	@Override
	protected void writeInternal(RcmRequestWrapper t, HttpOutputMessage outputMessage)
		throws IOException, HttpMessageNotWritableException
	{
		
	}
	
}