package com.eduonnetblog.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

@Service
public class ImageCompressionServiceImpl implements ImageCompressionService {

	@Override
	  public byte[] compress(byte[] imageData, String formatName) throws IOException {
        // Convert byte[] to BufferedImage
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
        BufferedImage image = ImageIO.read(inputStream);
        
        // Perform compression
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, formatName, outputStream);
        return outputStream.toByteArray();
    }
	// Decompress image
	@Override
	public BufferedImage decompress(byte[] imageData) throws IOException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
		return ImageIO.read(inputStream);
	}

	@Override
	public byte[] bufferedImageToByteArray(BufferedImage image, String formatName) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(image, formatName, outputStream);
		return outputStream.toByteArray();
	}
	
	/* how to use : bufferedImageToByteArray
	 *   // Convert BufferedImage to byte[]
        byte[] imageData = bufferedImageToByteArray(image, "jpg");
	 * */

}
