package develoPK.developk.api;

import develoPK.developk.domain.FileUploader;
import develoPK.developk.repository.FileRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class FileController {


    private final FileRepository fileRepository;
    String dir = "src";
    String file_path = "main/resources/static/image";
    File file3 = new File(dir, file_path);

    @GetMapping(value = "/image/view/", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getImage() // yyyymmdd_HHmmssZ // A
            throws IOException {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //String[] fileAr = fileTime.split("_");
        //String filePath = fileAr[0];

        //String fileDir = "D:\\Han\\sample\\" + filePath + "\\" + fileTime + "_" + value + ".png"; // 파일경로;
        String fileDir = "C:\\Users\\yyb40\\OneDrive\\Desktop\\test\\demo\\src\\main\\resources\\static\\images\\b9550834-ee10-45ab-9d9f-0ffcab500ab5.png";

        try {
            fis = new FileInputStream(fileDir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int readCount = 0;
        byte[] buffer = new byte[1024];
        byte[] fileArray = null;

        try {
            while ((readCount = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, readCount);
            }
            fileArray = baos.toByteArray();
            fis.close();
            baos.close();
        } catch (IOException e) {
            throw new RuntimeException("File Error");
        }
        return fileArray;
    }

    @GetMapping("/display")
    public ResponseEntity<Resource> display(@Param("filename") String filename, @Param("id") int id) {
        String path = file3.getAbsolutePath();

        switch (id) {
            case 1:
                filename = fileRepository.findById(1L).get().getFilename();
                break;
            case 2:
                filename = fileRepository.findById(2L).get().getFilename();
                break;
        }
        Resource resource = new FileSystemResource(path+"\\"+filename);
        System.out.println("================");
        System.out.println(path+"\\"+filename);
        System.out.println("================");

        if(!resource.exists())
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);

        HttpHeaders header = new HttpHeaders();
        Path filePath = null;

        try{
            filePath = Paths.get(path+"\\"+filename);
            header.add("Content-Type", Files.probeContentType(filePath));
        }catch(IOException e){
            e.printStackTrace();
        }
        return new ResponseEntity<Resource>(resource,header,HttpStatus.OK);
    }

    @GetMapping("/upload")
    public List<FileUploader> gotFile(){
        List<FileUploader> allFile = fileRepository.findAll();
        return allFile;
    }

    @PostMapping("/upload")
    public String saveFile(@RequestPart MultipartFile file) throws Exception {

        //String path = request.getSession().getServletContext().getRealPath("/");
        //String resource= new ClassPathResource("/static/image").getFile().getAbsolutePath();
        String absolutePath = file3.getAbsolutePath();
        String uploadFolder = absolutePath;
        //System.out.println(uploadFolder);
        //System.out.println("C:\\Users\\yyb40\\OneDrive\\Desktop\\test\\demo\\src\\main\\resources\\static\\images");
//        String uploadFolder = resource;

        UUID uuid = UUID.randomUUID();

        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length());
        String newFileName = uuid.toString() + extension;

        //System.out.println(newFileName);

        FileUploader fileUploaderCreate = FileUploader.createFile(newFileName, file.getOriginalFilename(),uploadFolder);
        fileRepository.save(fileUploaderCreate);


        File file2 = new File(uploadFolder, newFileName);

        try {
            file.transferTo(file2);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "200ok";
    }
}


