/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author yukit
 */
public class Article {
    private int article_ID;
    private String name;
    private String publicationDate;
    private String description;
    private String image;
    private String url;
    
    public Article() {
    }

    public Article(int article_ID) {
        this.article_ID = article_ID;
    }

    public Article(String name,String publicationDate,String description,String image, String url) {
        this.name = name;
        this.publicationDate = publicationDate;
        this.description = description;
        this.image = image;
        this.url = url;
    }

    public Article(int article_ID,String name,String publicationDate,String description,String image, String url) {
        this.article_ID=article_ID;
        this.name = name;
        this.publicationDate = publicationDate;
        this.description = description;
        this.image = image;
        this.url = url;
    }

    public int getArticle_ID() {
        return article_ID;
    }

    public void setArticle_ID(int article_ID) {
        this.article_ID = article_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Article{" + "article_ID=" + article_ID + ", name=" + name + ", publicationDate=" + publicationDate + ", description=" + description + ", image=" + image + ", url=" + url + '}';
    }
    
    
}
