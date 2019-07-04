package com.zzb.water.shop.common.context;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jdd on 2016/10/13.
 *
 * @author jdd
 */
public class InfoContext {
    // 晒单状态：启动
    public final static int INFO_SHOW_STATUS_START = 1;
    // 晒单状态：停用
    public final static int INFO_SHOW_STATUS_STOP = 0;

    // 踩赞来源类型：原贴
    public final static int INFO_LIKE_ORG_SOURCE_INFO = 1;
    // 踩赞来源类型：评论
    public final static int INFO_LIKE_ORG_SOURCE_REPLY = 2;

    // 大神推荐踩赞来源类型：推荐方案
    public final static int INFO_SCHEME_LIKE_ORG_SOURCE_SCHEME = 1;
    // 大神推荐踩赞来源类型：推荐方案评论
    public final static int INFO_SCHEME_LIKE_ORG_SOURCE_SCHEME_REPLY = 2;

    // 获取列表时：下一页
    public static final int TYPE_UP = 2;
    // 获取列表时：第一页
    public static final int TYPE_DOWN = 1;

    //根据资讯ID获取评论
    public static final int REPLY_TYPE_NEWSID = 1;
    //根据资讯ID获取评论
    public static final int REPLY_TYPE_ALL = 1;
    //根据楼层ID获取评论
    public static final int REPLY_TYPE_STOREY = 2;
    //根据用户ID获取评论
    public static final int REPLY_TYPE_USERID = 3;

    //infoLikeParams的orgType
    public final static Integer INFO_LIKE_TYPE = 1;
    public final static Integer INFO_LIKE_REPLY_TYPE = 2;
    // 资讯或者晒单的评论
    public static final int REPLY_NEWS = 1;
    // 赛事
    public static final int REPLY_GAME = 2;
    // 晒单评论
    public static final int REPLY_SHOW = 3;
    //大神发单评论
    public static final int REPLY_SCHEME = 4;
    //说盟视频评论
    public static final int REPLY_SM = 5;
    //竞足问答评论
    public static final int REPLY_QUIZZES = 6;
    //专家推荐
    public static final int REPLY_RECOM = 7;
    //新版评论
    public static final int REPLY_INFO = 8;

    // 踩赞类型：赞
    public final static int INFO_LIKE_TYPE_LIKE = 1;
    // 踩赞类型：踩
    public final static int INFO_LIKE_TYPE_NOT_LIKE = 0;

    // 最大举报次数，超过次数被举报的咨询或者评论会被删除
    public final static int MAX_COMPLAINT_COUNT = 5;
    //推荐方案点赞数   news_108:SchemeID
    public final static String CACHE_SCHEME_LIKE_COUNT_KEY = "info:scheme:like:count:%s";
    //推荐方案或赛后总结评论数 sreplycount:SchemeID_Category
    public final static String CACHE_SCHEME_CATEGORY_REPLY_COUNT_KEY = "info:scheme_category:reply:count:%s_%s";
    //专家推荐评论数 sreplycount:recomid
    public final static String CACHE_RECOM_CATEGORY_REPLY_COUNT_KEY = "info:recom_category:reply:count:%s";
    //新评论数 sorceId_recordId_category
    public final static String CACHE_REPLY_CATEGORY_REPLY_COUNT_KEY = "info:reply_category:reply:count:%s_%s_%s";

    //1，推荐理由
    public final static int SCHEME_CATEGORY_SCHEME_REASON_KEY = 1;
    //2，赛后总结
    public final static int SCHEME_CATEGORY_AFTER_GAME_KEY = 2;
    //3，推荐详情
    public final static int SCHEME_CATEGORY_SCHEME_DETAIL_KEY = 3;
    //3，专家推荐详情
    public final static int RECOM_CATEGORY_DETAIL_KEY = 1;
    //3，新评论推荐详情
    public final static int REPLY_CATEGORY_DETAIL_KEY = 0;

    // 咨询ID分类
    // 新闻、推荐类ID开头
    public final static Long INFO_ID_PREFIX_NEWS = 1L;
    // 新闻、推荐类评论ID开头
    public final static Long INFO_ID_PREFIX_NEWS_REPLY = 2L;
    // 晒单广场类ID开头
    public final static Long INFO_ID_PREFIX_SHOW = 3L;
    // 晒单广场类评论ID开头
    public final static Long INFO_ID_PREFIX_SHOW_REPLY = 4L;
    // 赛事类ID开头
    public final static Long INFO_ID_PREFIX_GAME = 5L;
    // 赛事类评论ID开头
    public final static Long INFO_ID_PREFIX_GAME_REPLY = 6L;

    public final static Long INFO_SEQUENCE = 7L;
    public final static String INFO_ID_SEQUNCE = "info:sequnce_id";
    public final static String INFO_REPLY_ID_SEQUNCE = "info:reply:sequnce_id";

    // 自定义ID长度
    public final static int INFO_ID_LENGTH = 9;

    // 新闻、推荐类ID序列
    public final static String INFO_ID_SEQUENCE_NEWS = "info:id_sequence:news";
    // 新闻、推荐类评论ID序列
    public final static String INFO_ID_SEQUENCE_NEWS_REPLY = "info:id_sequence:news_reply";
    // 晒单广场类ID序列
    public final static String INFO_ID_SEQUENCE_SHOW = "info:id_sequence:show";
    // 晒单广场评论类ID序列
    public final static String INFO_ID_SEQUENCE_SHOW_REPLY = "info:id_sequence:show_reply";
    // 赛事类ID序列
    public final static String INFO_ID_SEQUENCE_GAME = "info:id_sequence:game";
    // 赛事类评论ID序列
    public final static String INFO_ID_SEQUENCE_GAME_REPLY = "info:id_sequence:game_reply";

    //精彩留言id
    public final static Long INFO_ACTIVITY_REPLY = 1L;

    // 禁言类型
    // 用户id
    public final static int INFO_SHUT_UP_TYPE_USER_ID = 1;
    // 手机号
    public final static int INFO_SHUT_UP_TYPE_MOBILE = 2;
    // 身份证
    public final static int INFO_SHUT_UP_TYPE_ID = 3;
    // 设备号
    public final static int INFO_SHUT_UP_TYPE_CID = 4;

    public static String INFO_SHUT_UP_MONTHS = "3";

    public static String INFO_SHUT_UP_MIN_CONSUMPTION = "100";

    public final static String INFO_JDD_DESC = "酷彩吧";

    public final static String PLATFORM_ANDRIOD = "Android";

    public final static String PLATFORM_IPHONE = "IPHONE";

    public final static String DEFAULT_UEER_NAME = "游客";

    public final static String ERROR_ALREADY_LIKE = "您已经点赞过啦！";
    public final static String SUCCESS_COMPLAINT_DES = " 您的举报已经生效，官方正在紧急审核中，感谢您的支持";
    public final static String USER_NOT_VALIDATED = "请先进行身份证实名认证哦";
    public final static String REPLY_USER_NOT_GODSELF_OR_FOLLOWER = "跟单后才可以评论哦";
    public final static String LIKE_USER_NOT_GODSELF_OR_FOLLOWER = "跟单后才可以点赞哦";
    public final static String REPLY_IN_SHUT_UP_WORDS = "您违反了酷彩吧相关协议，已被禁言，可申请解除";
    public final static String REPLY_SHUT_UP_WORDS = "您发表的言论存在不符合平台规定的相关内容，将无法展示";
    public final static String REPLY_SHUT_UP_WORDS_YS = "当前消息需要审核后才能显示";

    public final static String SCHEME_USER_NOT_GODSELF_OR_FOLLOWER = "跟单后方可举报";

    public final static BigDecimal SCHEME_USER_NOT_FOLLOWER_MONEY = new BigDecimal(0);
    public final static BigDecimal SCHEME_USER_FOLLOWER_MONEY = new BigDecimal(20);

    //一小时内判断评论内容是否重复(毫秒数)
    public final static Long FREQUENTLY_SIMILAR_REPLY_TIME = 60 * 60 * 1000L;
    //一小时内只能发一次最大长度的评论
    public final static int FREQUENTLY_SIMILAR_GAME_REPLY_MAXLENGTH = 20;

    //字符长度大于10时判断评论是否相似
    public final static int FREQUENTLY_SIMILAR_REPLY_LENGTH = 5;
    //字符相似度
    public final static float FREQUENTLY_SIMILAR_REPLY_RATE = 0.6f;
    public final static String FREQUENTLY_SIMILAR_REPLY_MESSAGE = "一样的评论，一次就已足够";
    //一个小时内发布2条长度大于20的赛事评论
    public final static String FREQUENTLY_SIMILAR_LONG_GAME_REPLY_MESSAGE = "简短的评论更能被接受哦";

    public final static int SHOW_YES = 1;
    public final static int SHOW_NO = 0;

    public static int INFO_THUMBNAIL_X = 200;
    public static int INFO_THUMBNAIL_Y = 140;

    public static int INFO_NEW_THUMBNAIL_X = 300;
    public static int INFO_NEW_THUMBNAIL_Y = 95;
    public static int INFO_THUMBNAIL_NEW_X = 400;
    public static double INFO_THUMBNAIL_NEW_D_X = 400.0;
    public static double INFO_CutRate = 0.35;
    public static double INFO_LITTER_CutRate = 0.41;
    public static int INFO_THUMBNAIL_MIDDLE_X = 800;

    //系统广播
    public final static int INFO_NOTICE_TYPE_SYSTEM = 1;
    //个人广播
    public final static int INFO_NOTICE_TYPE_PERSONAGE = 2;
    public final static String INFO_MESSAGE_FOUNDER_ADMIN = "admin";

    //专题
    public final static Integer INFO_NEWS_BANNER_BUSINESSTYPE_ZT = 3;

    //新闻
    public final static int INFO_CATEGORY_NEWS = 1;
    //推荐新闻
    public final static int INFO_CATEGORY_NEWS_HOT = 2;
    //晒单
    public final static int INFO_CATEGORY_SHOW = 4;
    //竞技彩
    public final static int INFO_CATEGORY_NEWS_JJC = 5;
    //数字彩
    public final static int INFO_CATEGORY_NEWS_SZC = 6;
    //公告
    public final static int INFO_CATEGORY_NEWS_GG = 7;
    //订阅
    public final static int INFO_CATEGORY_NEWS_DY = 9;
    //专题
    public final static int INFO_CATEGORY_NEWS_ZT = 10;
    //专家推荐
    public final static int INFO_CATEGORY_RECOM_ZT = 11;


    //分析师类型
    //竞技彩
    public final static int INFO_ANALYST_CLASSIFY_JJC = 1;
    //数字彩
    public final static int INFO_ANALYST_CLASSIFY_SZC = 2;
    //初始化黑名单评论id
    public final static Long INFO_BLACK_REPLY_ID = 0L;
    //禁言
    public final static long INFO_FORVER_SHUTUP_DAY = 1095;
    public final static String INFO_SHUTUP_TEXT = "您的评论中含有不当内容，已被他人举报";
    public final static String INFO_SHUTUP_UNITS_DAY = "天";
    public final static String INFO_SHUTUP_UNITS_YEAR = "年";
    public final static Long INFO_BLACK_DATE_ONE_DAY = 1L;
    public final static Long INFO_BLACK_DATE_THREE_DAY = 3L;
    public final static Long INFO_BLACK_DATE_SEVEN_DAY = 7L;
    public final static Long INFO_BLACK_DATE_THREE_YEAR = 1095L;
    public final static String INFO_SHUTUP_NOTICE_TITLE = "禁言通知";

    public static String getShutupTxt(String reason, Long day, Date date) {
        if (day == null && date == null) {
            return "您已被禁言";
        }
        if (day.intValue() == 36500) {
            return "您已被禁言";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dates = format.format(date);
        return String.format("您因发表%s已被禁言%s天，解禁时间:%s。如有疑问，请联系客服人员申请解禁", reason, day, dates);
    }

    public static String getShutupText(String reason, Long day, Date date, String units) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dates = format.format(date);
        return String.format("您因发表不当内容,已被他人举报,将受禁言%s%s处理，解禁时间:%s", day, units, dates);
    }

    public static String getBlacklistText(Long day, Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dates = format.format(date);
        return String.format("您因发表不当言论,被用户举报,将受禁言%s天处理，解禁时间:%s", day, dates);
    }

    //系统管理员id
    public final static Long INFO_SYSTEM_MANAGER_ID = -1L;
    //系统管理员名称
    public final static String INFO_SYSTEM_MANAGER_NAME = "系统通知";
    public final static String INFO_SYSTEM_MANAGER_NAME_ENGLISH = "admin";

    //1个人中心举报
    public final static int INFO_COMPLAINT_TYPE_USER_CENTER = 1;
    //0赛后总结举报，
    public final static int INFO_COMPLAINT_TYPE_AFTER_GAME = 0;
    //2 推荐方案举报
    public final static int INFO_COMPLAINT_TYPE_SCHEME = 2;
    // 未读数类型：个人消息
    public final static int TYPE_SELF_UNREAD = 1;
    // 未读数类型：系统通知
    public final static int TYPE_SYSTEM_UNREAD = 2;
    //info_news中版权申明
    public final static String INFO_NEWS_COPYRIGHT = "<p><strong>【版权申明】本文仅代表作者观点，不代表酷彩吧官方立场，未经许可，不得转载。</strong></p>";
    /**
     * 1分钟内用户举报频繁提示
     */
    public final static String INFO_USER_ONE_MINUTE_COMPLAINT_MESSAGE = "举报一次就够了，系统：朕知道了";

    public final static String INFO_COMPLAINT_USER_MESSAGE = "您已经举报过了，客服MM正在加急核实处理中";

    public final static String INFO_CHAT_BLACKLIST_MESSAGE = "您因发表不当言论，被用户举报，聊天室账户封禁3天!";

    /**
     * 1天内用户举报同一个评论提示
     */
    public final static String INFO_COMPLAINT_USER_CONTENT_MESSAGE = "您已经举报过了，客服MM正在加急核实处理中";

    /**
     * 评论时黑名单提示
     */
    public final static String INFO_IN_BLACKLIST_MESSAGE = "由于您被多个用户举报，您暂时无法发起内容";

    //1、手动加黑名单
    public final static int INFO_ADD_BLACKLIST_MANUAL = 1;
    //2、自动加黑名单
    public final static int INFO_ADD_BLACKLIST_AUTO = 2;

    //1、手动解除黑名单
    public final static int INFO_DEL_BLACKLIST_MANUAL = 1;
    //2、自动解除黑名单
    public final static int INFO_DEL_BLACKLIST_AUTO = 2;

    //评论举报内容通过字符串模糊匹配，内容最小长度
    public final static int INFO_STRING_COMPLAINT_LENGTH = 5;

    public final static int YES = 1;
    public final static int NO = 0;

    //个人消息类型
    public final static int INFO_NOTICE_NEWS = 1;
    public final static int INFO_NOTICE_SHOW = 2;
    public final static int INFO_NOTICE_GAME = 3;
    public final static int INFO_NOTICE_SCHEME = 4;
    public final static int INFO_NOTICE_RECOM = 5;
    public final static int INFO_NOTICE_NEWS_REWARD = 17;

    /**
     * =====================资讯频道==================
     */

    //资讯推荐用户缓存
    public final static String INFO_NEWS_RECOMMEND_USERID = "info:news:recommend:%s";
    //资讯推荐标准
    public final static double INFO_NEWS_RECOMMEND_STANDARD = 0.25;

    //资讯频道首页新闻条数
    public final static int INFO_NEWS_PD_INDEX_SIZE = 5;
    //资讯频道首页新闻最近1天新闻优先
    public final static int INFO_NEWS_PD_INDEX_DAYS = 1;

    //资讯频道推荐新闻最近3天新闻优先
    public final static int INFO_NEWS_PD_TJ_DAYS = 3;

    //上传任务晒单
    public final static int INFO_UPLOAD_MISSION_SHOW = 8;
    //上报任务评论
    public final static int INFO_UPLOAD_MISSION_REPLY = 10;

    //资讯打赏列表(注意是缓存资讯详情里的前26个打赏)
    public final static String INFO_NEWS_REWARD_LIST_TOP = "info:news:reward:%s";
    //与资讯作者相关联的分析师缓存
    public final static String INFO_NEWS_AUTHOR_ANALYST = "info:news:author:analyst:%s";

    //资讯详情里显示的打赏数
    public final static Integer INFO_NEWS_REWARD_LIST_TOP_NUM = 26;
    //可以打赏
    public final static Integer INFO_NEWS_CAN_REWARD_STATUS = 1;
    //不可以打赏
    public final static Integer INFO_NEWS_CANT_REWARD_STATUS = 0;
    //是否订阅
    public final static Integer INFO_NEWS_ANALYST_IS_SUBSCIBE = 1;
    public final static Integer INFO_NEWS_ANALYST_NOT_SUBSCIBE = 0;
    //分析师是否停用
    public final static Integer INFO_NEWS_ANALYST_OFF = 0;
    public final static Integer INFO_NEWS_ANALYST_ON = 1;
    public final static String INFO_NEWS_ANALYST_OFF_MSG = "您打赏的分析师请长假了";
    //打赏原因
    public final static String INFO_NEWS_REWARD_REASON = "资讯打赏";

    //彩种--竞彩足球
    public final static int INFO_LOTTERY_JCZQ = 90;
    //彩种--竞彩篮球
    public final static int INFO_LOTTERY_JCLQ = 91;
    //彩种-超级大乐透
    public final static int INFO_LOTTERY_DLT = 39;


    //安卓新接口版本
    public final static int NEW_INTERFACE_ANDROID = 380;
    //安卓新接口版本
    public final static int NEW_INTERFACE_IPHONE = 382;

    //后台系统的默认traceId
    public final static String SYSTEM_TRACEID_DEFAULT = "0";

    //禁言类型 0手动1 自动
    public final static Integer SHUT_UP_TYPE_MANUAL = 0;
    public final static Integer SHUT_UP_TYPE_AUTO = 1;

    //资讯通知安卓老版本版本号
    public final static String ANDROID_NEWS_NOTICE_VERSION = "3.8.7";
    //资讯通知ios老版本版本号
    public final static String IOS_NEWS_NOTICE_VERSION = "5.0.1";

    //推单和晒单评论安卓老版本
    public final static String ANDROID_HOT_REPLY_VERSION = "3.9.1";
    //推单和晒单评论ios老版本
    public final static String IOS_HOT_REPLY_VERSION = "5.1.3";

    //赛事被删除评论显示文案
    public final static String INFO_GAME_REPLY_DELETE_SHOW_TXT = "该条评论违反酷彩吧星球基本法，已被删除";

    //资讯,字典,敏感词,禁言关键词同步
    public final static String INFO_SYNC_NEWS_SECRETKEY = "x3YmI1NYUCL2S2Ymal8OXA1=";
    public final static String SYNCDATA_NEWS = "newsUrl";
    public final static String SYNCDATA_DIC = "dicUrl";
    public final static String SYNCDATA_SENSITIVE = "senUrl";
    public final static String SYNCDATA_SHUTUP = "shutupUrl";
    public final static String SYNCDATA_ANALYST = "analystUrl";

    public final static int NEWS_IS_SHOW_YES = 1;
    public final static int NEWS_IS_SHOW_NO = 0;

    public final static String PLATFORM_CODE_IPHONE = "IPHONE";
    public final static String PLATFORM_CODE_H5MOBILE = "h5mobile";
    public final static String PLATFORM_CODE_H5WAP = "H5wap";
    public final static String PLATFORM_CODE_ANDORID = "ANDORID";

    public final static Long SCHEME_ID_STEP = 999L;

    public final static int PER_HOUR_SECOND = 60;
    public final static int PER_HOUR_MINUTES = 60;
    public final static int PER_DAY_HOURS = 24;

    public final static String EXCEL_TYPE_XLS = "xls";
    public final static String EXCEL_TYPE_XLSX = "xlsx";

    public final static String GAME_REPLY_MAP_KEY_LEVEL_NAME = "levelname";
    public final static String GAME_REPLY_MAP_KEY_USER_LEVEL = "userlevel";

    public final static int USER_LEVEL_TWO = 2;
    public final static int USER_LEVEL_THREE = 3;

    /**
     * 玩法
     * 9001：让球胜平负
     * 9002：总进球
     * 9003：猜比分
     * 9004：半全场
     * 9006：胜平负
     */
    public final static String MATCH_GAME_TYPE_RQSFP = "9001";
    public final static String MATCH_GAME_TYPE_ZJQ = "9002";
    public final static String MATCH_GAME_TYPE_CBF = "9003";
    public final static String MATCH_GAME_TYPE_BQC = "9004";
    public final static String MATCH_GAME_TYPE_SFP = "9006";


    public final static String INFO_NOTICE_PLATFORM_CODE_IPHONE = "IPHONE";
    public final static String INFO_NOTICE_PLATFORM_CODE_ANDROID = "Android";

    /**
     * 评论对象类型
     * 1赛事
     * 2资讯
     * 3晒单
     * 4大神
     */
    public final static int REPLY_GAME_TYPE_SS = 1;
    public final static int REPLY_GAME_TYPE_ZX = 2;
    public final static int REPLY_GAME_TYPE_SD = 3;
    public final static int REPLY_GAME_TYPE_DS = 4;

    public final static String INFO_SHOW_MAP_KEY_LEVEL_NAME = "levelname";
    public final static String INFO_SHOW_MAP_KEY_USER_LEVEL = "userlevel";

    public final static int MOBILE_USER_NAME_MAX_LENGTH = 4;

    //系统通知
    public final static String NOTICE_MESSAGE_TYPE_SYSTEM = "1";
    //消息提醒
    public final static String NOTICE_MESSAGE_TYPE_NOTICE = "2";

    public final static int ONLINE_COUNT_MIN = 10;

    public final static int INFO_SHOW_TYPE_THREE_IMAGE = 3;
    public final static int INFO_SHOW_TYPE_SMALL_IMAGE = 1;

    public final static String PALTFORM_CODE_AY = "AY";
    public final static String PALTFORM_CODE_BY = "BY";

    //彩种知识过关类型
    //新手篇
    public final static int INFO_LOTTERY_KNOWLEDGE_PASS_NEWER = 1;
    //专家篇
    public final static int INFO_LOTTERY_KNOWLEDGE_PASS_PROFESSION = 2;
    //封神篇
    public final static int INFO_LOTTERY_KNOWLEDGE_PASS_GODS = 3;

    public final static String INFO_LOTTERY_KNOWLEDGE_AWARDCARD = "info.konwledge.card";

    public final static int CACHE_MINUTE_UNIT_TIME = 60;
    public final static int CACHE_HOUR_UNIT_TIME = 60 * 60;
    public final static int CACHE_DAY_UNIT_TIME = 60 * 60 * 24;

    public final static int CACHE_SECOND_UNIT_TIME = 1;

    //默认品牌
    public final static String DEFAULT_BRAND_CODE = "jdd_app";

    public final static int LOTTERY_JCZQ_ID = 90;
    public final static int LOTTERY_JCLQ_ID = 91;

    public final static int CONTENT_LENGTH_MIN = 10;
    public final static int CONTENT_LENGTH_MAX = 1100;

    public final static int QUIZZES_ANSWER_ADD_INTEGRAL = 100;
    public final static String QUIZZES_ANSWER_ADD_INTEGRAL_DESC = "竞足问答奖励";

    //举报类型 1:资讯 2:晒单 3:晒单评论 4:赛事 5:方案  6:个人中心,9：专家推荐
    public final static int COMPLAINT_NEWS = 1;
    public final static int COMPLAINT_SHOW = 2;
    public final static int COMPLAINT_SHOW_REPLY = 3;
    public final static int COMPLAINT_GAME = 4;
    public final static int COMPLAINT_SCHEME = 5;
    public final static int COMPLAINT_USER_CENTER = 6;
    public final static int COMPLAINT_SCHEME_REPLY = 7;
    public final static int COMPLAINT_SM_VIDEO = 8;
    public final static int COMPLAINT_RECOM_REPLY = 9;

    public final static String ANDROID_DYNAMIC_VERSION = "5.0.6";
    //资讯通知ios老版本版本号
    public final static String IOS_DYNAMIC_VERSION = "5.3.0";

    /**
     * 敏感词类型
     */
    public final static int SENSITIVE_WORD_MIN_MATCHTYPE = 1;
    public final static int SENSITIVE_WORD_MAX_MATCHTYPE = 2;

    /*禁言关键词标识**/
    public final static long INFO_SHUTUP_WORDS_PASS = 0;
    public final static long INFO_SHUTUP_WORDS_DOUBT = 1;
    public final static long INFO_SHUTUP_WORDS_NO_PASS = 2;
    public final static long INFO_SHUTUP_WORDS_EXCEPTION = 3;

    /*乐善奖编码**/
    public final static String INFO_DLT_LESHAN_CODE17 = "3917=";
    public final static String INFO_DLT_LESHAN_CODE18 = "3918=";
    public final static String INFO_DLT_LESHAN_CODE19 = "3919=";
    public final static String INFO_DLT_LESHAN_CODE20 = "3920=";
    public final static String INFO_DLT_LESHAN_CODE21 = "3921=";
    public final static String INFO_DLT_LESHAN_CODE22 = "3922=";

    public final static String INFO_SYS_SHUTUP_MSG = "系统禁言%s天，原因：%s";

    /**
     * 观点阅读活动状态         0关闭  1开启
     */
    public final static int READ_ACTIVITY_CLOSE = 0;
    public final static int READ_ACTIVITY_OPEN = 1;
    /**
     * 观点阅读活动阅读状态       1已读 0未读
     */
    public final static int READ_ACTIVITY_READ = 1;
    public final static int READ_ACTIVITY_UNREAD = 0;

    /**
     * 精选tab
     */
    public final static int INFO_TOPIC_TAB_SELECT = 1;
    public final static int INFO_TOPIC_TAB_NEWEAST = 2;

    /**
     * 配置开关类型
     */
    public final static String INFO_CONFIG_SWITCH_TYPE = "switch";

    /**
     * 热门话题开关
     */
    public final static String INFO_CONFIG_SWITCH_HOT_TOPIC = "topic";

    public final static String SYNC_NEWS_ENV = "pro";
    public final static  String SYNC_NEWS_RESULT_NO_ENV = "环境参数缺失";

    public final static String INFO_ACTION_HTTP_URL = "info.actionUrl";

    public final static String INFO_PUSH_ACTION_HTTP_URL = "info.sendPush.url";

    public final static String INFO_CONFIG_ATUO_RECOMMEND_INDEX_NEWS = "indexRecommend";
    public final static String INFO_CONFIG_ATUO_RECOMMEND_GD_NEWS = "gdRecommend";
    public final static String NUMBER_STR_ONE = "1";
    public final static String INFO_CONFIG_INDEX_NEWS_NUM = "indexNewsNum";
    /**
     * redis不能覆盖的值
     */
    public final static String NUMBER_REDIS_ONE = "1";
    public final static Long NUMBER_REDIS_ONE_COVER = 0L;
    /**
     * 重复点击
     */
    public final static int INFO_CONTINUE_CLICK = 1;
    public final static int INFO_NO_MORE_MONEY = 2;
    public final static int INFO_SUCCESS = 0;
}
