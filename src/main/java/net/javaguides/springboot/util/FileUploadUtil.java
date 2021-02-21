package net.javaguides.springboot.util;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.impl.EmployeeService;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    public static String renderImage(Employee employee, String oldEmployeeImage, MultipartFile multipartFile) {
        String fileName = null;
        if (multipartFile.getSize() > 0) {
            fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        } else {
//            Check update with no file upload
            if(employee.getId() != null) {
//                Already has image
                if(oldEmployeeImage != null) {
                    fileName = oldEmployeeImage;;
                }
            }
        }
        return fileName;
    }

    public static void saveFile(MultipartFile multipartFile, String uploadDir, String fileName) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path filePath = uploadPath.resolve(fileName);   // resolve = get file path
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file " + fileName);
        }
    }
}