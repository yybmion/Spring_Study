package develoPK.developk.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileUploader {

    @Id
    @GeneratedValue
    private Long id;

    //@Value("${file.dir}")
    @Column(nullable = false)
    private String filename;
    @Column(nullable = false)
    private String fileOriName;
    @Column(nullable = false)
    private String fileFullName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;


    //생성 메서드

    public static FileUploader createFile(String filename, String fileOriName,String fileFullName){
        FileUploader fileUploader = new FileUploader();
        fileUploader.setFilename(filename);
        fileUploader.setFileOriName(fileOriName);
        fileUploader.setFileFullName(fileFullName);

        return fileUploader;
    }

}
