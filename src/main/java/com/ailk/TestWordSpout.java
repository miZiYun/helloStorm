package com.ailk;

import java.util.Map;
import java.util.Random;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestWordSpout extends BaseRichSpout {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5969477900109782667L;
	public static Logger LOG = LoggerFactory.getLogger(TestWordSpout.class);
	   SpoutOutputCollector _collector;

	public void nextTuple() {
		// TODO Auto-generated method stub
		Utils.sleep(10000);
	       final String[] words = new String[] {"nathan", "mike", "jackson", "golda", "bertels"};
	       final Random rand = new Random();
	       final String word = words[rand.nextInt(words.length)];
	       _collector.emit(new Values(word));

	}

	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector collector) {
		// TODO Auto-generated method stub
		_collector = collector;
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("word"));

	}

}
