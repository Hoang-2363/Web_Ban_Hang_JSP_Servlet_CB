package admin.dal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.Part;

public class LSX_Anh {
	public String Ten_Anh(Part path, String url) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String formattedDateTime = now.format(formatter);
		return formattedDateTime + "_" + path.getSubmittedFileName();
	}

	public void Luu_Anh(Part path, String url) {
		String fileName = Ten_Anh(path, url);
		// Kiểm tra xem file đã tồn tại chưa
		Path existingFilePath = Paths.get(url, path.getSubmittedFileName());
		if (Files.exists(existingFilePath)) {
			try {
				Files.delete(existingFilePath); // Xóa file cũ
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Lưu file mới
		Path newFilePath = Paths.get(url, fileName);
		try (InputStream fileContent = path.getInputStream()) {
			Files.copy(fileContent, newFilePath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Cập nhật ảnh thành công.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Xoa_Anh(String url) {
		Path pathToDelete = Paths.get(url);

		if (Files.exists(pathToDelete)) {
			try {
				Files.delete(pathToDelete);
				System.out.println("Xóa ảnh thành công: " + url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Lỗi xóa ảnh: " + url);
		}

	}
}
