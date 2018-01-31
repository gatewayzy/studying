package _programming.instance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 单程车合并为双程车问题：rule1直接往返，rule2构成一个环，rule3同省合并。合并要求：rule优先级递减，合并需要车型一致，两个小车可以和一个大车构成双程
 * 输入：
 350410;嘉兴中心;浙江省;西安中心;陕西省;9.6m;
 350424;西安中心;陕西省;嘉兴中心;浙江省;9.6m;
 350428;嘉兴中心;浙江省;长沙中心;湖南省;17.5m;
 350432;长沙中心;湖南省;武汉中心;湖北省;17.5m;
 350448;武汉中心;湖北省;嘉兴中心;浙江省;17.5m;
 350476;嘉兴中心;浙江省;潍坊中心;山东省;9.6m;
 350479;潍坊中心;山东省;嘉兴中心;浙江省;17.5m;
 350481;嘉兴中心;浙江省;成都中心;四川省;9.6m;
 * 输出：
 rule1:350410+350424
 rule2:350428+350432+350448
 */
public class UniLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 6) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        String rule1 = "rule1:";
        String rule2 = "rule2:";
        String rule3 = "rule3:";

        // 遍历比较rule1，还没有考虑两个小车与大车合并的问题
        for (int i = 0; i < lineList.size() - 1 && lineList.get(i).id != null; i++) {
            for (int j = i; j < lineList.size() && lineList.get(j).id != null; j++) {
                if (lineList.get(i).sCen.equals(lineList.get(j).eCen) && lineList.get(i).sPro.equals(lineList.get(j).ePro) &&
                        lineList.get(i).eCen.equals(lineList.get(j).sCen) && lineList.get(i).ePro.equals(lineList.get(j).sPro))
                    if (lineList.get(i).tType.equals(lineList.get(j).tType)) {
                        result.add(rule1 + lineList.get(i).id + "+" + lineList.get(j).id);
                        lineList.get(i).setId(null);
                        lineList.get(j).setId(null);
                    }
            }
        }

        // 遍历比较rule2
        for (int i = 0; i < lineList.size() - 1; i++) {
            if (lineList.get(i).id == null) continue;
            for (int j = i; j < lineList.size(); j++) {
                if (lineList.get(j).id == null) continue;
                for (int k = 0; k < lineList.size() ; k++) {
                    if (lineList.get(k).id == null || k == i || k == j) continue;
                    if (lineList.get(i).sCen.equals(lineList.get(j).eCen) && lineList.get(i).sPro.equals(lineList.get(j).ePro) &&
                            lineList.get(i).eCen.equals(lineList.get(k).sCen) && lineList.get(i).ePro.equals(lineList.get(k).sPro) &&
                            lineList.get(k).eCen.equals(lineList.get(j).sCen) && lineList.get(k).ePro.equals(lineList.get(j).sPro)) {
                        if (lineList.get(i).tType.equals(lineList.get(j).tType) && lineList.get(i).tType.equals(lineList.get(k).tType)) {
                            result.add(rule2 + lineList.get(i).id + "+" + lineList.get(k).id + "+" + lineList.get(j).id);
                            lineList.get(i).setId(null);
                            lineList.get(k).setId(null);
                            lineList.get(i).setId(null);
                        }
                    }
                }
            }
        }

        //  遍历比较rule3
        for (int i = 0; i < lineList.size() - 1; i++) {
            if (lineList.get(i).id == null) continue;
            for (int j = i; j < lineList.size(); j++) {
                if (lineList.get(j).id == null) continue;
                if (!lineList.get(i).sCen.equals(lineList.get(j).eCen) && lineList.get(i).sPro.equals(lineList.get(j).ePro) &&
                        !lineList.get(i).eCen.equals(lineList.get(j).sCen) && lineList.get(i).ePro.equals(lineList.get(j).sPro))
                    if (lineList.get(i).tType.equals(lineList.get(j).tType)) {
                        result.add(rule3 + lineList.get(i).id + "+" + lineList.get(j).id);
                        lineList.get(i).setId(null);
                        lineList.get(j).setId(null);
                    }
            }
        }

        return result;
    }

    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型

        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
            this.id = id;
            this.sCen = sCen;
            this.sPro = sPro;
            this.eCen = eCen;
            this.ePro = ePro;
            this.tType = tType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSCen() {
            return sCen;
        }

        public void setSCen(String ePro) {
            this.ePro = ePro;
        }

        public String getSPro() {
            return sPro;
        }

        public void setSPro(String sPro) {
            this.sPro = sPro;
        }

        public String getECen() {
            return eCen;
        }

        public void setECen(String eCen) {
            this.eCen = eCen;
        }

        public String getEPro() {
            return ePro;
        }

        public void setEPro(String ePro) {
            this.ePro = ePro;
        }

        public String getTType() {
            return tType;
        }

        public void setTType(String tType) {
            this.tType = tType;
        }
    }
}