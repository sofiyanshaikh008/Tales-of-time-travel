package com.masai.Entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorDetail {
	private LocalDateTime timeStamp;
	private String message;
	private String details;
}