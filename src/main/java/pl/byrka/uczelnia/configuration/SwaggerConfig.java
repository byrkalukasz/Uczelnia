package pl.byrka.uczelnia.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket configurationAPI() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Configuration").select()
                .apis(RequestHandlerSelectors.basePackage("pl.byrka.uczelnia.controller.Configuration"))
                .build();
    }
    @Bean
    public Docket studentAPI() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Student").select()
                .apis(RequestHandlerSelectors.basePackage("pl.byrka.uczelnia.controller.Student"))
                .build();
    }
    @Bean
    public Docket fileAPI() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("File").select()
                .apis(RequestHandlerSelectors.basePackage("pl.byrka.uczelnia.controller.FileController"))
                .build();
    }
    @Bean
    public Docket gradeAPI() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Grade").select()
                .apis(RequestHandlerSelectors.basePackage("pl.byrka.uczelnia.controller.Grade"))
                .build();
    }
    @Bean
    public Docket groupAPI() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Group").select()
                .apis(RequestHandlerSelectors.basePackage("pl.byrka.uczelnia.controller.Group"))
                .build();
    }
    @Bean
    public Docket LecturerAPI() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Lecturer").select()
                .apis(RequestHandlerSelectors.basePackage("pl.byrka.uczelnia.controller.Lecturer"))
                .build();
    }
    @Bean
    public Docket MajorAPI() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Major").select()
                .apis(RequestHandlerSelectors.basePackage("pl.byrka.uczelnia.controller.Major"))
                .build();
    }
    @Bean
    public Docket SpecializationAPI() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Specialization").select()
                .apis(RequestHandlerSelectors.basePackage("pl.byrka.uczelnia.controller.Specialization"))
                .build();
    }
    @Bean
    public Docket SubjectAPI() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Subject").select()
                .apis(RequestHandlerSelectors.basePackage("pl.byrka.uczelnia.controller.Subject"))
                .build();
    }
}
