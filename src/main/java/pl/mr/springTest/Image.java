package pl.mr.springTest;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileName;

    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] data;
}
