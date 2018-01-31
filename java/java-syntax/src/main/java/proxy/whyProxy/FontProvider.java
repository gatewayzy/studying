package proxy.whyProxy;

import java.util.Arrays;

/**https://www.zhihu.com/question/20794107
 * Created by dell on 2017/7/18.
 */
public class FontProvider {
//    int getFont(String name);

    public static void main(String[] args) {
        double[] arra = new double[]{1,2,0,1.1};
        double[] arrb = new double[10];
        System.out.println(arra.length);
        Arrays.sort(arra);
        System.out.println(Arrays.toString(arra));
    }
}

//public abstract class ProviderFactory {
//    public static FontProvider getFontProvider() {
//        return new FontProviderFromDisk();
//    }
//}
//
//public static void main(String[] args) {
//        FontProvider fontProvider = ProviderFactory.getFontProvider();
//        int font = fontProvider.getFont("微软雅黑");
//        }


