package com.task.article.dto;

import com.task.article.entity.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDto {
    private String text;
    private Color color;
}
