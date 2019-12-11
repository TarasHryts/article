package com.task.article.dto.util;

import com.task.article.dto.ArticleDto;
import com.task.article.entity.Article;

public class ArticleDtoUtil {
    public static Article createArticleFromDto(ArticleDto articleDto) {
        Article article = new Article();
        article.setText(articleDto.getText());
        article.setColor(articleDto.getColor());
        return article;
    }
}
