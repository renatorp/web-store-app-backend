package com.example.webstoreappbackend;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.webstoreappbackend.exception.BadRequestException;
import com.example.webstoreappbackend.exception.NotFoundException;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import feign.Response;
import feign.codec.ErrorDecoder;

public class AppErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder defaultErrorDecoder = new Default();

	private static final Logger log = LoggerFactory.getLogger(AppErrorDecoder.class);

	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.status() == 404 || response.status() == 400) {
			try {
				JsonParser jsonParser = new JsonParser();
				JsonElement parse = jsonParser.parse(response.body().asReader());
				String message = parse.getAsJsonObject().get("message").getAsString();

				switch (response.status()) {
				case 404:
					throw new NotFoundException(message);
				case 400:
					throw new BadRequestException(message);
				}

			} catch (IOException e) {
				log.error("ERROR", e);
			}
		}

		return defaultErrorDecoder.decode(methodKey, response);
	}
}
