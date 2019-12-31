package boostbrain.FileStatistic.Controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    //class RestResponse класс который будет передовать какие-то данные
    //этот класс будет представлять собой описание тех ДАННЫХ
    //которые будет возвращать наш REST service
    public static class RestResponse{
        private String param1;
        private String param2;

//        public RestResponse(String param1, String param2) {
//            this.param1 = param1;
//            this.param2 = param2;
//        }

        public String getParam1() {
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public String getParam2() {
            return param2;
        }

        public void setParam2(String param2) {
            this.param2 = param2;
        }

    }
    //этот метод будет нашим сервисом который мы будем вызывать
    //value = "/hello"-контекст этого метода (та строка которая добавляеться после имени
    // хоста чтобы получить доступ именно к этому методу
    //method = RequestMethod.GET,-метод вызода http метод с помощью которого вызываеться эта
    //функция
    //produces в каком виде будет возвращать данные в данном случае строка JSON Value
    // MediaType выбираем springframework.http
    @RequestMapping(value = "/hello", method = RequestMethod.GET,//
    produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse restMethod(String name){

           RestResponse result = new RestResponse();
          result.setParam1("Hello");
           result.setParam2(name);
           return result;
    }
}
