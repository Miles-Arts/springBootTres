# springBootTres

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }



//Archivo JSON
1. {
2. "nombre": "Rodriguez Lopez",
3. "email": "rodrigo.lopez@voll.med",
4. "documento": "ORTOPEDIA",
5. "dirección": {
6.  "calle" : "calle 1",
7. "distrito": "distrito 1",
8. "ciudad": "roma",
9. "numero": "1",
10. "complemento": "a"
11. }
12. }


//Metodología del negocio 

![img.png](img.png)

}
