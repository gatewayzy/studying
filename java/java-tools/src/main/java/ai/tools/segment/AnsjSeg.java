package ai.tools.segment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.ansj.util.FilterModifWord;
import org.ansj.util.MyStaticValue;

/**
 * ansj seg 分词开源项目 https://github.com/NLPchina/ansj_seg
 */
public class AnsjSeg {
    private static final KeyWordComputer kwc = new KeyWordComputer(7);
    static String text = "麻黄欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!";

    // 词典配置在library.properties
    public static void main(String args[]) throws Exception {
        ansjParse();
        //advancedSegment();
        //userDefineSegment();
    }

    /**
     * 自定义词性优先、词性标注
     */
    private static void userDefineSegment() {
        //分词
        List<Term> terms = ToAnalysis.parse(text);
        // 设置词性以用户词典的词性优先
        FilterModifWord.modifResult(terms);
        System.out.println(terms);

        //词性过滤，自定义词典中添加词性如：麻黄\t userDefine\t 1000
        for (Term term : terms) {
            System.out.println(term.toString());
        }
    }

    /**
     * 关键词抽取、自定义词典词性优先、词性标注
     */
    private static void advancedSegment() {
        Set<String> set = new HashSet<String>();

        //关键词抽取
        Collection<Keyword> result = kwc.computeArticleTfidf(text);
        System.out.println(result);

        //词性标注
        List<Term> terms = ToAnalysis.parse(text);
        System.out.println(terms);
        //词性标注
        FilterModifWord.modifResult(terms);
        System.out.println(terms);

        //词性过滤，自定义词典中添加词性如：麻黄\t userDefine\t 1000
        for (Term term : terms) {
            String termStr = term.toString();
            if (termStr.endsWith("/userDefine") || termStr.endsWith("/n") || termStr.endsWith("/v")) {
                set.add(term.getName());
            }
        }
        //返回词
        for (Keyword keyword : result) {
            System.out.println(keyword.getName());
        }
    }

    /**
     * 基本的最简单的ansj分词
     */
    private static void ansjParse() {
        System.out.println(ToAnalysis.parse(text));
    }

    public static void stop() {
        MyStaticValue.userLibrary = "src/main/resources/dic/tcm_ext_dic.dic";
        System.out.println("用户词典100多MB，加载比较慢");
        String text = "麻黄的功效，甘草的性味归经";

        // 添加停用词
        List<String> stopwords = new ArrayList<>();
        stopwords.add("的");
        stopwords.add("啥");
        FilterModifWord.insertStopWords(stopwords);

        List<Term> terms = ToAnalysis.parse(text);
        System.out.println(terms);
        // 设置词性以用户词典的词性优先
        FilterModifWord.modifResult(terms);
        System.out.println(terms);
    }

}
