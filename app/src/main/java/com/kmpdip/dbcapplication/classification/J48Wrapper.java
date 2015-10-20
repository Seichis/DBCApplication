package com.kmpdip.dbcapplication.classification;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;

public class J48Wrapper extends WekaWrapper {
	
	Classifier classifier = null;

    @Override
	public Instances loadInstancesFromArffFile(String fileName) {

		String dirPath =
				Environment.getExternalStorageDirectory()
						+ "/"
						+ Constants.WORKING_DIR_NAME;
		String filePath = dirPath + "/" + fileName;

		try {
			BufferedReader reader =
					new BufferedReader(new FileReader(filePath));
			Instances data = new Instances(reader);
			if (data.classIndex() == -1)
				data.setClassIndex(data.numAttributes() - 1);
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(TAG, "loadInstancesFromArffFile() error : " + e.getMessage());
		}

		return null;
	}

	@Override
	public void train(Instances instances) {
		try {
			classifier = new J48();
			classifier.buildClassifier(instances);
			instancesForTraining = instances;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(TAG, "Train() error : " + e.getMessage());
			classifier = null;
		}
	}

	@Override
	public String predict(Instance instance) {
		String resultClass = null;
		try {
			Object[] s = new Object[instance.numAttributes()];

			for (int j = 0; j < s.length; j++) {
				if (!instance.isMissing(j)) {
					if (instance.attribute(j).isNominal())
						s[j] = new String(instance.stringValue(j));
					else if (instance.attribute(j).isNumeric())
						s[j] = new Double(instance.value(j));
				}
			}

			// set class value to missing
			s[instance.classIndex()] = null;
//			Log.i(TAG, "Instance added : " + DecisionTreeClassifier.classify(s));
//			double result = DecisionTreeClassifier.classify(s);
//			resultClass = String.valueOf(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultClass;
	}


}
