package top.cyc.servlet.qrCode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Gengerate")

// 获取二维码
public class GetQRCode extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("data");
        String content = data;    // 二维码内容
        int width = 200;    //二维码宽度；
        int height = 200;   // 图像高度
        String format = "png";  // 图像类型
        OutputStream outputStream = response.getOutputStream();
        // 内容编码格式
        Map<EncodeHintType, Object> hints = new HashMap<>();
        // 指定纠错等级
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 这是二维码的空度， 非负数
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.MARGIN,1);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, format, outputStream);
        } catch (WriterException e){
            e.printStackTrace();
        }
        finally {
            if(outputStream != null){
                outputStream.flush();
                outputStream.close();
            }
        }

    }

    private void QRCode() throws WriterException, IOException{

    }
}
