package boostbrain.FileStatistic.Controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    //class RestResponse ����� ������� ����� ���������� �����-�� ������
    //���� ����� ����� ������������ ����� �������� ��� ������
    //������� ����� ���������� ��� REST service
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
    //���� ����� ����� ����� �������� ������� �� ����� ��������
    //value = "/hello"-�������� ����� ������ (�� ������ ������� ������������ ����� �����
    // ����� ����� �������� ������ ������ � ����� ������
    //method = RequestMethod.GET,-����� ������ http ����� � ������� �������� ����������� ���
    //�������
    //produces � ����� ���� ����� ���������� ������ � ������ ������ ������ JSON Value
    // MediaType �������� springframework.http
    @RequestMapping(value = "/hello", method = RequestMethod.GET,//
    produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse restMethod(String name){

           RestResponse result = new RestResponse();
          result.setParam1("Hello");
           result.setParam2(name);
           return result;
    }
}
