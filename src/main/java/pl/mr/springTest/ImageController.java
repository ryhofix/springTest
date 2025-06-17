package pl.mr.springTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/images")
    public Long uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setData(file.getBytes());
        image = imageRepository.save(image);
        return image.getId();
    }

    @GetMapping(value = "/images/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        return imageRepository.findById(id)
                .map(img -> ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img.getData()))
                .orElse(ResponseEntity.notFound().build());
    }
}
