package com.example.task_ovid;

/*
Esta clase es necesaria para poder ejecutar los tests de cucumber. Sin embargo, debido a un
problema de versiones no reconoce los archivos del proyecto y da alguna de las siguientes
excepciones (en función de que versión de la dependencia de cucumber se use):
- No backend support
- No file or directory
Puede probarse el funcionamiento de la clase descomentando los imports y las anotaciones que
aparecen a continuación
 */
/*
import org.junit.runner.RunWith;
import io.cucumber.android.runner.CucumberAndroidJUnitRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features"
)
*/
public class TestRunner {

}