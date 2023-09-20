package com.example.apiRestfulprojetosOrla.exception;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseError {
    private String timestamp;
    private String status;
    private String error;
    private String message;
}
