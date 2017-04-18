
import java.awt.image.BufferedImage;

import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.HybridBinarizer;

public class AztecSimpleReader {

	public static String getString(BufferedImage bimg) throws NotFoundException, FormatException {
		String res = null;
		LuminanceSource ls = new BufferedImageLuminanceSource(bimg);
		HybridBinarizer hb = new HybridBinarizer(ls);
		BitMatrix bm = hb.getBlackMatrix();
		Detector detector = new Detector(bm);
		AztecDetectorResult adr = (AztecDetectorResult) detector.detect();
		if (adr != null) {
			Decoder decoder = new Decoder();
			DecoderResult decoderResult = decoder.decode(adr);
			res = decoderResult.getText();
		}
		return res;
	}

	public static byte[] getBytesArray(BufferedImage bimg) throws NotFoundException, FormatException {
		byte[] res = null;
		LuminanceSource ls = new BufferedImageLuminanceSource(bimg);
		HybridBinarizer hb = new HybridBinarizer(ls);
		BitMatrix bm = hb.getBlackMatrix();
		Detector detector = new Detector(bm);
		AztecDetectorResult adr = (AztecDetectorResult) detector.detect();
		if (adr != null) {
			Decoder decoder = new Decoder();
			DecoderResult decoderResult = decoder.decode(adr);
			res = decoderResult.getRawBytes();
		}
		return res;
	}
}
