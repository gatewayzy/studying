package ai.ml.cluster.DBScan.dataOnFocus;


import java.util.List;


public interface Algorithm {

public void setPoints(List<DataPoint> points);

public void cluster();

}