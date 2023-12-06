import Controller.ProductController;
import Controller.PredictionController;
import Model_classifier.ProductModel;
import Model_classifier.RandomForestModel;
import View.MainView;
import javax.swing.*;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            try {
                // 初始化随机森林模型
                RandomForestModel randomForestModel = new RandomForestModel();

                // 创建预测控制器
                PredictionController predictionController = new PredictionController(randomForestModel.getRandomForest());

                // CSV文件路径
                String csvFilePath = "C:\\Users\\cao10\\Downloads\\Amazon-Predict-Worth-or-Not-Worth-with-Random-forest-\\amazon_product.csv";

                // 创建产品模型
                ProductModel model = new ProductModel(csvFilePath);

                // 先创建 MainView 实例（暂不传入 ProductController）
                MainView mainView = new MainView(null);

                // 创建 ProductController 实例，传入所有必要的参数
                ProductController productController = new ProductController(model, predictionController, mainView);

                // 现在设置 ProductController 到 MainView
                mainView.setController(productController);

                // 显示主视图
                mainView.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
                // 处理异常，例如显示错误消息
            }
        });
    }


}

