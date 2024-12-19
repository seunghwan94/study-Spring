package com.example.member_post.vo;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;

@Data
@Builder
@Alias("attach")
@AllArgsConstructor
@NoArgsConstructor
public class Attach {
	private String uuid;
	private String origin;
	private String path;
	private boolean image;
	private Long pno;

	// @Value("${upload.path}")
	public static String UPLOAD_PATH = "c:/upload";

	public Attach (MultipartFile file){
		origin = file.getOriginalFilename();
		int dotIdx = origin.lastIndexOf(".");
		String ext = "";
		if(dotIdx != -1){
			ext = origin.substring(dotIdx);
		}
		String uuid = UUID.randomUUID().toString();
		String realName = uuid + ext;
		path = getTodayStr();
		File parentPath = new File(UPLOAD_PATH, path);
		if(!parentPath.exists()){
			parentPath.mkdirs();
		}

		try{
			File f = new File(parentPath, realName);
			file.transferTo(f);
			
			// 마임 타입 체크
			String mime = Files.probeContentType(f.toPath());
			image = mime != null && mime.startsWith("image");

			// thumbnailtor
			if(image){
				File thumb = new File(parentPath, "t_" + realName);
				Thumbnailator.createThumbnail(f, thumb, 100,100);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
		
	public String getTodayStr() {
		return new SimpleDateFormat("yyyy/MM/dd").format(System.currentTimeMillis());
	}
		
	public File toFile(){
		return null;
	}



}
