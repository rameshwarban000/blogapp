package com.eduonnetblog.services;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ImageCompressionService {

	byte[] compress(BufferedImage image, String formatName) throws IOException;

	BufferedImage decompress(byte[] imageData) throws IOException;

	byte[] bufferedImageToByteArray(BufferedImage image, String formatName) throws IOException;

}
