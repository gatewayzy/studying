package ai.tools.weka;

import java.io.File;
import java.io.IOException;

import weka.classifiers.Classifier;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 *
 */
public class MyWeka {

    public static void main(String[] args) throws Exception {
        //myJ48();
        mySVM();
    }

    /**
     * weka的J48算法
     *
     * @throws IOException
     * @throws Exception
     * @link 博客：http://blog.csdn.net/felomeng/article/details/4688257
     * http://blog.csdn.net/Felomeng/article/details/4687061
     * [Weka里面各种分类器的使用(Java)](http://blog.csdn.net/u014563989/article/details/44241351)
     */
    private static void myJ48() throws IOException, Exception {
        Classifier m_classifier = new J48();
        File inputFile = new File("src/main/resources/files/arff/weather.arff");// 训练语料文件
        ArffLoader atf = new ArffLoader();
        atf.setFile(inputFile);
        Instances instancesTrain = atf.getDataSet(); // 读入训练文件
        inputFile = new File("src/main/resources/files/arff/weather.arff");// 测试语料文件
        atf.setFile(inputFile);
        Instances instancesTest = atf.getDataSet(); // 读入测试文件
        instancesTrain.setClassIndex(0);
        instancesTest.setClassIndex(0); // 设置分类属性所在行号（第一行为0号）

        double sum = instancesTest.numInstances();// 测试语料实例数
        double right = 0.0f;
        m_classifier.buildClassifier(instancesTrain); // 训练
        for (int i = 0; i < sum; i++)// 测试分类结果
        {
            System.out.println("分类预测结果为：" + m_classifier.classifyInstance(instancesTest.instance(i)));
            if (m_classifier.classifyInstance(instancesTest.instance(i)) == instancesTest.instance(i).classValue())// 如果预测值和答案值相等（测试语料中的分类列提供的须为正确答案，结果才有意义）
            {
                right++;// 正确值加1
            }
        }
        System.out.println("J48 classification precision:" + (right / sum));
    }

    /**
     * weka的libSVM第三方算法
     *
     * @throws IOException
     * @throws Exception
     */
    private static void mySVM() throws IOException, Exception {
        Classifier m_classifier = new LibSVM();
        File inputFile = new File("src/main/resources/files/arff/weather.arff");// 训练语料文件
        ArffLoader atf = new ArffLoader();
        atf.setFile(inputFile);
        Instances instancesTrain = atf.getDataSet(); // 读入训练文件
        inputFile = new File("src/main/resources/files/arff/weather.arff");// 测试语料文件
        atf.setFile(inputFile);
        Instances instancesTest = atf.getDataSet(); // 读入测试文件
        instancesTrain.setClassIndex(0);
        instancesTest.setClassIndex(0); // 设置分类属性所在行号（第一行为0号）

        double sum = instancesTest.numInstances();// 测试语料实例数
        double right = 0.0f;
        m_classifier.buildClassifier(instancesTrain); // 训练
        for (int i = 0; i < sum; i++)// 测试分类结果
        {
            System.out.println("分类预测结果为：" + m_classifier.classifyInstance(instancesTest.instance(i)));
            if (m_classifier.classifyInstance(instancesTest.instance(i)) == instancesTest.instance(i).classValue())// 如果预测值和答案值相等（测试语料中的分类列提供的须为正确答案，结果才有意义）
            {
                right++;// 正确值加1
            }
        }
        System.out.println("J48 classification precision:" + (right / sum));
    }

}
