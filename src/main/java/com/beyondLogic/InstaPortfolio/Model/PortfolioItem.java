package com.beyondLogic.InstaPortfolio.Model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PortfolioItem {
    @lombok.Setter
    @lombok.Getter
    private Integer id;

    @lombok.Setter
    @lombok.Getter
    @NotBlank(message="Please enter title")

    private String title;

    @lombok.Setter
    @lombok.Getter
    @Size(max=50, message = "Description should be maximum 50 characters")
    private String description;

    @lombok.Setter
    @lombok.Getter
    @NotBlank(message="Please enter project Url")
    private String projectUrl;

    @lombok.Setter
    @lombok.Getter
    @NotBlank(message="Select an option")
    private String projectType;

    @lombok.Setter
    @lombok.Getter

    @NotBlank(message="Please enter tools")
    private String tools;

    @lombok.Setter
    @lombok.Getter

    @NotBlank(message="Please enter programming Languages or none")
    private String programmingLanguage;

    public PortfolioItem(Integer id, String title, String description, String projectUrl, String projectType, String tools, String programmingLanguage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.projectUrl = projectUrl;
        this.projectType = projectType;
        this.tools = tools;
        this.programmingLanguage = programmingLanguage;
    }

    public PortfolioItem() {
    }
}
