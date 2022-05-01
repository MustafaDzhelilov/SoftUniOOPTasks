import java.util.List;

public class Smartphone implements Browsable,Callable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if(validUrl(url)){
                sb.append(String.format("Browsing: %s!",url));
            }else{
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String call() {
       StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if(validNumber(number)){
                sb.append(String.format("Calling... %s",number));
            }else{
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private boolean validNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            if(Character.isLetter(current)){
                return false;
            }
        }
        return true;
    }


    private boolean validUrl(String url) {
        for (int i = 0; i < url.length(); i++) {
            char current = url.charAt(i);
            if(Character.isDigit(current)){
                return false;
            }
        }
        return true;
    }

}
