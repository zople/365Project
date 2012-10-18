/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service;

import com.zople.dao.basic.DictionaryFacade;
import com.zople.domain.basic.Dictionary;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import jeasy.analysis.MMAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 搜索分词bean
 *
 * @author 王文彦
 */
@Singleton
@Startup
public class SegmentWordsServiceBean implements SegmentWordsServiceBeanLocal {

    private static final Logger logger = LoggerFactory.getLogger(SegmentWordsServiceBean.class);
    private static MMAnalyzer analyzer = null;
    private static String SEPARATOR = " ";
    @EJB
    private DictionaryFacade dictionaryFacade;

    public SegmentWordsServiceBean() {
        logger.info("创建SegmentWordsServiceBean");
    }

    /**
     * 加载词库
     */
    @PostConstruct
    @Override
    public void loadDictionary() {
        loadDictionary(false);
    }

    /**
     * 加载词库
     *
     * @param clearDictionary 加载词库时是否清理之前词典
     */
    @Override
    public void loadDictionary(boolean clearDictionary) {
        logger.info("开始加载词库");
        if (clearDictionary) {
            MMAnalyzer.clear();
        }
        List<Dictionary> dictionaries = dictionaryFacade.findAll();
        for (Dictionary dictionary : dictionaries) {
            if (!MMAnalyzer.contains(dictionary.getWord())) {
                MMAnalyzer.addWord(dictionary.getWord());
                logger.info("词库加载：" + dictionary.getWord());
            }
        }
        logger.info("词库加载完成");
        analyzer = new MMAnalyzer();

    }

    /**
     * 对文本进行分词
     *
     * @param text 文本
     * @param separator 分隔符
     * @return
     */
    @Override
    public String segment(String text, String separator) {
        try {
            return analyzer.segment(text, separator);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(SegmentWordsServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * 对文本进行分词，以空格间隔
     *
     * @param text 要分词的文本
     * @return
     */
    @Override
    public String segment(String text) {
        return segment(text, SEPARATOR);
    }
}
