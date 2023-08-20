import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetectionfromPHOTO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialize OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        //CREATE A FACE DETECTER
        CascadeClassifier faceCascade = new CascadeClassifier();
        faceCascade.load("C:\\opencv\\sources\\data\\haarcascades_cuda\\haarcascade_frontalface_alt.xml");
        
		//LOAD AN IMAGE
		Mat image= Imgcodecs.imread("D:\\img.jpg");
        
        //DETECT FACES
        MatOfRect faceDetections = new MatOfRect();
        faceCascade.detectMultiScale(image, faceDetections);
        
        // Check if any faces were detected
        if (faceDetections.toArray().length > 0) {
            // Draw rectangles around detected faces
            for (Rect rect : faceDetections.toArray()) {
                Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 15);
            }
        
        //save the result
        String filenameString="output.jpg";
        Imgcodecs.imwrite("D:\\"+filenameString,image);
        System.out.println("Faces detected and saved as output.jpg");
        } 
        else {
            System.out.println("No faces detected.");
        }
        
	}

}

