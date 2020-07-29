package com.liy.generator.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SfcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SfcExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andHandleIsNull() {
            addCriterion("HANDLE is null");
            return (Criteria) this;
        }

        public Criteria andHandleIsNotNull() {
            addCriterion("HANDLE is not null");
            return (Criteria) this;
        }

        public Criteria andHandleEqualTo(String value) {
            addCriterion("HANDLE =", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotEqualTo(String value) {
            addCriterion("HANDLE <>", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThan(String value) {
            addCriterion("HANDLE >", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThanOrEqualTo(String value) {
            addCriterion("HANDLE >=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThan(String value) {
            addCriterion("HANDLE <", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThanOrEqualTo(String value) {
            addCriterion("HANDLE <=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLike(String value) {
            addCriterion("HANDLE like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotLike(String value) {
            addCriterion("HANDLE not like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleIn(List<String> values) {
            addCriterion("HANDLE in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotIn(List<String> values) {
            addCriterion("HANDLE not in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleBetween(String value1, String value2) {
            addCriterion("HANDLE between", value1, value2, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotBetween(String value1, String value2) {
            addCriterion("HANDLE not between", value1, value2, "handle");
            return (Criteria) this;
        }

        public Criteria andChangeStampIsNull() {
            addCriterion("CHANGE_STAMP is null");
            return (Criteria) this;
        }

        public Criteria andChangeStampIsNotNull() {
            addCriterion("CHANGE_STAMP is not null");
            return (Criteria) this;
        }

        public Criteria andChangeStampEqualTo(BigDecimal value) {
            addCriterion("CHANGE_STAMP =", value, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andChangeStampNotEqualTo(BigDecimal value) {
            addCriterion("CHANGE_STAMP <>", value, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andChangeStampGreaterThan(BigDecimal value) {
            addCriterion("CHANGE_STAMP >", value, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andChangeStampGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHANGE_STAMP >=", value, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andChangeStampLessThan(BigDecimal value) {
            addCriterion("CHANGE_STAMP <", value, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andChangeStampLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHANGE_STAMP <=", value, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andChangeStampIn(List<BigDecimal> values) {
            addCriterion("CHANGE_STAMP in", values, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andChangeStampNotIn(List<BigDecimal> values) {
            addCriterion("CHANGE_STAMP not in", values, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andChangeStampBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHANGE_STAMP between", value1, value2, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andChangeStampNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHANGE_STAMP not between", value1, value2, "changeStamp");
            return (Criteria) this;
        }

        public Criteria andSiteIsNull() {
            addCriterion("SITE is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("SITE is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(String value) {
            addCriterion("SITE =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("SITE <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("SITE >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("SITE >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("SITE <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("SITE <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLike(String value) {
            addCriterion("SITE like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("SITE not like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<String> values) {
            addCriterion("SITE in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("SITE not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("SITE between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("SITE not between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSfcIsNull() {
            addCriterion("SFC is null");
            return (Criteria) this;
        }

        public Criteria andSfcIsNotNull() {
            addCriterion("SFC is not null");
            return (Criteria) this;
        }

        public Criteria andSfcEqualTo(String value) {
            addCriterion("SFC =", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcNotEqualTo(String value) {
            addCriterion("SFC <>", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcGreaterThan(String value) {
            addCriterion("SFC >", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcGreaterThanOrEqualTo(String value) {
            addCriterion("SFC >=", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcLessThan(String value) {
            addCriterion("SFC <", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcLessThanOrEqualTo(String value) {
            addCriterion("SFC <=", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcLike(String value) {
            addCriterion("SFC like", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcNotLike(String value) {
            addCriterion("SFC not like", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcIn(List<String> values) {
            addCriterion("SFC in", values, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcNotIn(List<String> values) {
            addCriterion("SFC not in", values, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcBetween(String value1, String value2) {
            addCriterion("SFC between", value1, value2, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcNotBetween(String value1, String value2) {
            addCriterion("SFC not between", value1, value2, "sfc");
            return (Criteria) this;
        }

        public Criteria andStatusBoIsNull() {
            addCriterion("STATUS_BO is null");
            return (Criteria) this;
        }

        public Criteria andStatusBoIsNotNull() {
            addCriterion("STATUS_BO is not null");
            return (Criteria) this;
        }

        public Criteria andStatusBoEqualTo(String value) {
            addCriterion("STATUS_BO =", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoNotEqualTo(String value) {
            addCriterion("STATUS_BO <>", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoGreaterThan(String value) {
            addCriterion("STATUS_BO >", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS_BO >=", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoLessThan(String value) {
            addCriterion("STATUS_BO <", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoLessThanOrEqualTo(String value) {
            addCriterion("STATUS_BO <=", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoLike(String value) {
            addCriterion("STATUS_BO like", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoNotLike(String value) {
            addCriterion("STATUS_BO not like", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoIn(List<String> values) {
            addCriterion("STATUS_BO in", values, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoNotIn(List<String> values) {
            addCriterion("STATUS_BO not in", values, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoBetween(String value1, String value2) {
            addCriterion("STATUS_BO between", value1, value2, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoNotBetween(String value1, String value2) {
            addCriterion("STATUS_BO not between", value1, value2, "statusBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoIsNull() {
            addCriterion("SHOP_ORDER_BO is null");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoIsNotNull() {
            addCriterion("SHOP_ORDER_BO is not null");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoEqualTo(String value) {
            addCriterion("SHOP_ORDER_BO =", value, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoNotEqualTo(String value) {
            addCriterion("SHOP_ORDER_BO <>", value, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoGreaterThan(String value) {
            addCriterion("SHOP_ORDER_BO >", value, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_ORDER_BO >=", value, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoLessThan(String value) {
            addCriterion("SHOP_ORDER_BO <", value, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoLessThanOrEqualTo(String value) {
            addCriterion("SHOP_ORDER_BO <=", value, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoLike(String value) {
            addCriterion("SHOP_ORDER_BO like", value, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoNotLike(String value) {
            addCriterion("SHOP_ORDER_BO not like", value, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoIn(List<String> values) {
            addCriterion("SHOP_ORDER_BO in", values, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoNotIn(List<String> values) {
            addCriterion("SHOP_ORDER_BO not in", values, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoBetween(String value1, String value2) {
            addCriterion("SHOP_ORDER_BO between", value1, value2, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andShopOrderBoNotBetween(String value1, String value2) {
            addCriterion("SHOP_ORDER_BO not between", value1, value2, "shopOrderBo");
            return (Criteria) this;
        }

        public Criteria andQtyIsNull() {
            addCriterion("QTY is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("QTY is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(BigDecimal value) {
            addCriterion("QTY =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(BigDecimal value) {
            addCriterion("QTY <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(BigDecimal value) {
            addCriterion("QTY >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(BigDecimal value) {
            addCriterion("QTY <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<BigDecimal> values) {
            addCriterion("QTY in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<BigDecimal> values) {
            addCriterion("QTY not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyDoneIsNull() {
            addCriterion("QTY_DONE is null");
            return (Criteria) this;
        }

        public Criteria andQtyDoneIsNotNull() {
            addCriterion("QTY_DONE is not null");
            return (Criteria) this;
        }

        public Criteria andQtyDoneEqualTo(BigDecimal value) {
            addCriterion("QTY_DONE =", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneNotEqualTo(BigDecimal value) {
            addCriterion("QTY_DONE <>", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneGreaterThan(BigDecimal value) {
            addCriterion("QTY_DONE >", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_DONE >=", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneLessThan(BigDecimal value) {
            addCriterion("QTY_DONE <", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_DONE <=", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneIn(List<BigDecimal> values) {
            addCriterion("QTY_DONE in", values, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneNotIn(List<BigDecimal> values) {
            addCriterion("QTY_DONE not in", values, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_DONE between", value1, value2, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_DONE not between", value1, value2, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedIsNull() {
            addCriterion("QTY_SCRAPPED is null");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedIsNotNull() {
            addCriterion("QTY_SCRAPPED is not null");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedEqualTo(BigDecimal value) {
            addCriterion("QTY_SCRAPPED =", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedNotEqualTo(BigDecimal value) {
            addCriterion("QTY_SCRAPPED <>", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedGreaterThan(BigDecimal value) {
            addCriterion("QTY_SCRAPPED >", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_SCRAPPED >=", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedLessThan(BigDecimal value) {
            addCriterion("QTY_SCRAPPED <", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_SCRAPPED <=", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedIn(List<BigDecimal> values) {
            addCriterion("QTY_SCRAPPED in", values, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedNotIn(List<BigDecimal> values) {
            addCriterion("QTY_SCRAPPED not in", values, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_SCRAPPED between", value1, value2, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_SCRAPPED not between", value1, value2, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinIsNull() {
            addCriterion("QTY_HISTORICAL_MIN is null");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinIsNotNull() {
            addCriterion("QTY_HISTORICAL_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinEqualTo(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MIN =", value, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinNotEqualTo(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MIN <>", value, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinGreaterThan(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MIN >", value, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MIN >=", value, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinLessThan(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MIN <", value, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MIN <=", value, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinIn(List<BigDecimal> values) {
            addCriterion("QTY_HISTORICAL_MIN in", values, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinNotIn(List<BigDecimal> values) {
            addCriterion("QTY_HISTORICAL_MIN not in", values, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_HISTORICAL_MIN between", value1, value2, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_HISTORICAL_MIN not between", value1, value2, "qtyHistoricalMin");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxIsNull() {
            addCriterion("QTY_HISTORICAL_MAX is null");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxIsNotNull() {
            addCriterion("QTY_HISTORICAL_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxEqualTo(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MAX =", value, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxNotEqualTo(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MAX <>", value, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxGreaterThan(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MAX >", value, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MAX >=", value, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxLessThan(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MAX <", value, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_HISTORICAL_MAX <=", value, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxIn(List<BigDecimal> values) {
            addCriterion("QTY_HISTORICAL_MAX in", values, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxNotIn(List<BigDecimal> values) {
            addCriterion("QTY_HISTORICAL_MAX not in", values, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_HISTORICAL_MAX between", value1, value2, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andQtyHistoricalMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_HISTORICAL_MAX not between", value1, value2, "qtyHistoricalMax");
            return (Criteria) this;
        }

        public Criteria andItemBoIsNull() {
            addCriterion("ITEM_BO is null");
            return (Criteria) this;
        }

        public Criteria andItemBoIsNotNull() {
            addCriterion("ITEM_BO is not null");
            return (Criteria) this;
        }

        public Criteria andItemBoEqualTo(String value) {
            addCriterion("ITEM_BO =", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoNotEqualTo(String value) {
            addCriterion("ITEM_BO <>", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoGreaterThan(String value) {
            addCriterion("ITEM_BO >", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_BO >=", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoLessThan(String value) {
            addCriterion("ITEM_BO <", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoLessThanOrEqualTo(String value) {
            addCriterion("ITEM_BO <=", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoLike(String value) {
            addCriterion("ITEM_BO like", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoNotLike(String value) {
            addCriterion("ITEM_BO not like", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoIn(List<String> values) {
            addCriterion("ITEM_BO in", values, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoNotIn(List<String> values) {
            addCriterion("ITEM_BO not in", values, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoBetween(String value1, String value2) {
            addCriterion("ITEM_BO between", value1, value2, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoNotBetween(String value1, String value2) {
            addCriterion("ITEM_BO not between", value1, value2, "itemBo");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(BigDecimal value) {
            addCriterion("PRIORITY =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(BigDecimal value) {
            addCriterion("PRIORITY <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(BigDecimal value) {
            addCriterion("PRIORITY >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRIORITY >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(BigDecimal value) {
            addCriterion("PRIORITY <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRIORITY <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<BigDecimal> values) {
            addCriterion("PRIORITY in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<BigDecimal> values) {
            addCriterion("PRIORITY not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRIORITY between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRIORITY not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("LOCATION =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("LOCATION <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("LOCATION >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("LOCATION <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("LOCATION <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("LOCATION like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("LOCATION not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("LOCATION in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("LOCATION not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("LOCATION between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("LOCATION not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedIsNull() {
            addCriterion("RMA_MAX_TIMES_PROCESSED is null");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedIsNotNull() {
            addCriterion("RMA_MAX_TIMES_PROCESSED is not null");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedEqualTo(BigDecimal value) {
            addCriterion("RMA_MAX_TIMES_PROCESSED =", value, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedNotEqualTo(BigDecimal value) {
            addCriterion("RMA_MAX_TIMES_PROCESSED <>", value, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedGreaterThan(BigDecimal value) {
            addCriterion("RMA_MAX_TIMES_PROCESSED >", value, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RMA_MAX_TIMES_PROCESSED >=", value, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedLessThan(BigDecimal value) {
            addCriterion("RMA_MAX_TIMES_PROCESSED <", value, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RMA_MAX_TIMES_PROCESSED <=", value, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedIn(List<BigDecimal> values) {
            addCriterion("RMA_MAX_TIMES_PROCESSED in", values, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedNotIn(List<BigDecimal> values) {
            addCriterion("RMA_MAX_TIMES_PROCESSED not in", values, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RMA_MAX_TIMES_PROCESSED between", value1, value2, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andRmaMaxTimesProcessedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RMA_MAX_TIMES_PROCESSED not between", value1, value2, "rmaMaxTimesProcessed");
            return (Criteria) this;
        }

        public Criteria andLccBoIsNull() {
            addCriterion("LCC_BO is null");
            return (Criteria) this;
        }

        public Criteria andLccBoIsNotNull() {
            addCriterion("LCC_BO is not null");
            return (Criteria) this;
        }

        public Criteria andLccBoEqualTo(String value) {
            addCriterion("LCC_BO =", value, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoNotEqualTo(String value) {
            addCriterion("LCC_BO <>", value, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoGreaterThan(String value) {
            addCriterion("LCC_BO >", value, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoGreaterThanOrEqualTo(String value) {
            addCriterion("LCC_BO >=", value, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoLessThan(String value) {
            addCriterion("LCC_BO <", value, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoLessThanOrEqualTo(String value) {
            addCriterion("LCC_BO <=", value, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoLike(String value) {
            addCriterion("LCC_BO like", value, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoNotLike(String value) {
            addCriterion("LCC_BO not like", value, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoIn(List<String> values) {
            addCriterion("LCC_BO in", values, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoNotIn(List<String> values) {
            addCriterion("LCC_BO not in", values, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoBetween(String value1, String value2) {
            addCriterion("LCC_BO between", value1, value2, "lccBo");
            return (Criteria) this;
        }

        public Criteria andLccBoNotBetween(String value1, String value2) {
            addCriterion("LCC_BO not between", value1, value2, "lccBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoIsNull() {
            addCriterion("ORIGINAL_STATUS_BO is null");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoIsNotNull() {
            addCriterion("ORIGINAL_STATUS_BO is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoEqualTo(String value) {
            addCriterion("ORIGINAL_STATUS_BO =", value, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoNotEqualTo(String value) {
            addCriterion("ORIGINAL_STATUS_BO <>", value, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoGreaterThan(String value) {
            addCriterion("ORIGINAL_STATUS_BO >", value, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_STATUS_BO >=", value, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoLessThan(String value) {
            addCriterion("ORIGINAL_STATUS_BO <", value, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoLessThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_STATUS_BO <=", value, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoLike(String value) {
            addCriterion("ORIGINAL_STATUS_BO like", value, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoNotLike(String value) {
            addCriterion("ORIGINAL_STATUS_BO not like", value, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoIn(List<String> values) {
            addCriterion("ORIGINAL_STATUS_BO in", values, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoNotIn(List<String> values) {
            addCriterion("ORIGINAL_STATUS_BO not in", values, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoBetween(String value1, String value2) {
            addCriterion("ORIGINAL_STATUS_BO between", value1, value2, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andOriginalStatusBoNotBetween(String value1, String value2) {
            addCriterion("ORIGINAL_STATUS_BO not between", value1, value2, "originalStatusBo");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedIsNull() {
            addCriterion("QTY_MULT_PERFORMED is null");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedIsNotNull() {
            addCriterion("QTY_MULT_PERFORMED is not null");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedEqualTo(String value) {
            addCriterion("QTY_MULT_PERFORMED =", value, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedNotEqualTo(String value) {
            addCriterion("QTY_MULT_PERFORMED <>", value, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedGreaterThan(String value) {
            addCriterion("QTY_MULT_PERFORMED >", value, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedGreaterThanOrEqualTo(String value) {
            addCriterion("QTY_MULT_PERFORMED >=", value, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedLessThan(String value) {
            addCriterion("QTY_MULT_PERFORMED <", value, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedLessThanOrEqualTo(String value) {
            addCriterion("QTY_MULT_PERFORMED <=", value, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedLike(String value) {
            addCriterion("QTY_MULT_PERFORMED like", value, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedNotLike(String value) {
            addCriterion("QTY_MULT_PERFORMED not like", value, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedIn(List<String> values) {
            addCriterion("QTY_MULT_PERFORMED in", values, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedNotIn(List<String> values) {
            addCriterion("QTY_MULT_PERFORMED not in", values, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedBetween(String value1, String value2) {
            addCriterion("QTY_MULT_PERFORMED between", value1, value2, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andQtyMultPerformedNotBetween(String value1, String value2) {
            addCriterion("QTY_MULT_PERFORMED not between", value1, value2, "qtyMultPerformed");
            return (Criteria) this;
        }

        public Criteria andActualCompDateIsNull() {
            addCriterion("ACTUAL_COMP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andActualCompDateIsNotNull() {
            addCriterion("ACTUAL_COMP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andActualCompDateEqualTo(Date value) {
            addCriterion("ACTUAL_COMP_DATE =", value, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andActualCompDateNotEqualTo(Date value) {
            addCriterion("ACTUAL_COMP_DATE <>", value, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andActualCompDateGreaterThan(Date value) {
            addCriterion("ACTUAL_COMP_DATE >", value, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andActualCompDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ACTUAL_COMP_DATE >=", value, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andActualCompDateLessThan(Date value) {
            addCriterion("ACTUAL_COMP_DATE <", value, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andActualCompDateLessThanOrEqualTo(Date value) {
            addCriterion("ACTUAL_COMP_DATE <=", value, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andActualCompDateIn(List<Date> values) {
            addCriterion("ACTUAL_COMP_DATE in", values, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andActualCompDateNotIn(List<Date> values) {
            addCriterion("ACTUAL_COMP_DATE not in", values, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andActualCompDateBetween(Date value1, Date value2) {
            addCriterion("ACTUAL_COMP_DATE between", value1, value2, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andActualCompDateNotBetween(Date value1, Date value2) {
            addCriterion("ACTUAL_COMP_DATE not between", value1, value2, "actualCompDate");
            return (Criteria) this;
        }

        public Criteria andPrevSiteIsNull() {
            addCriterion("PREV_SITE is null");
            return (Criteria) this;
        }

        public Criteria andPrevSiteIsNotNull() {
            addCriterion("PREV_SITE is not null");
            return (Criteria) this;
        }

        public Criteria andPrevSiteEqualTo(String value) {
            addCriterion("PREV_SITE =", value, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteNotEqualTo(String value) {
            addCriterion("PREV_SITE <>", value, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteGreaterThan(String value) {
            addCriterion("PREV_SITE >", value, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteGreaterThanOrEqualTo(String value) {
            addCriterion("PREV_SITE >=", value, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteLessThan(String value) {
            addCriterion("PREV_SITE <", value, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteLessThanOrEqualTo(String value) {
            addCriterion("PREV_SITE <=", value, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteLike(String value) {
            addCriterion("PREV_SITE like", value, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteNotLike(String value) {
            addCriterion("PREV_SITE not like", value, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteIn(List<String> values) {
            addCriterion("PREV_SITE in", values, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteNotIn(List<String> values) {
            addCriterion("PREV_SITE not in", values, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteBetween(String value1, String value2) {
            addCriterion("PREV_SITE between", value1, value2, "prevSite");
            return (Criteria) this;
        }

        public Criteria andPrevSiteNotBetween(String value1, String value2) {
            addCriterion("PREV_SITE not between", value1, value2, "prevSite");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyIsNull() {
            addCriterion("ORIGINAL_TRANSFER_KEY is null");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyIsNotNull() {
            addCriterion("ORIGINAL_TRANSFER_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyEqualTo(String value) {
            addCriterion("ORIGINAL_TRANSFER_KEY =", value, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyNotEqualTo(String value) {
            addCriterion("ORIGINAL_TRANSFER_KEY <>", value, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyGreaterThan(String value) {
            addCriterion("ORIGINAL_TRANSFER_KEY >", value, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_TRANSFER_KEY >=", value, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyLessThan(String value) {
            addCriterion("ORIGINAL_TRANSFER_KEY <", value, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyLessThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_TRANSFER_KEY <=", value, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyLike(String value) {
            addCriterion("ORIGINAL_TRANSFER_KEY like", value, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyNotLike(String value) {
            addCriterion("ORIGINAL_TRANSFER_KEY not like", value, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyIn(List<String> values) {
            addCriterion("ORIGINAL_TRANSFER_KEY in", values, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyNotIn(List<String> values) {
            addCriterion("ORIGINAL_TRANSFER_KEY not in", values, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyBetween(String value1, String value2) {
            addCriterion("ORIGINAL_TRANSFER_KEY between", value1, value2, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andOriginalTransferKeyNotBetween(String value1, String value2) {
            addCriterion("ORIGINAL_TRANSFER_KEY not between", value1, value2, "originalTransferKey");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveIsNull() {
            addCriterion("IMMEDIATE_ARCHIVE is null");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveIsNotNull() {
            addCriterion("IMMEDIATE_ARCHIVE is not null");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveEqualTo(String value) {
            addCriterion("IMMEDIATE_ARCHIVE =", value, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveNotEqualTo(String value) {
            addCriterion("IMMEDIATE_ARCHIVE <>", value, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveGreaterThan(String value) {
            addCriterion("IMMEDIATE_ARCHIVE >", value, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveGreaterThanOrEqualTo(String value) {
            addCriterion("IMMEDIATE_ARCHIVE >=", value, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveLessThan(String value) {
            addCriterion("IMMEDIATE_ARCHIVE <", value, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveLessThanOrEqualTo(String value) {
            addCriterion("IMMEDIATE_ARCHIVE <=", value, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveLike(String value) {
            addCriterion("IMMEDIATE_ARCHIVE like", value, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveNotLike(String value) {
            addCriterion("IMMEDIATE_ARCHIVE not like", value, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveIn(List<String> values) {
            addCriterion("IMMEDIATE_ARCHIVE in", values, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveNotIn(List<String> values) {
            addCriterion("IMMEDIATE_ARCHIVE not in", values, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveBetween(String value1, String value2) {
            addCriterion("IMMEDIATE_ARCHIVE between", value1, value2, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andImmediateArchiveNotBetween(String value1, String value2) {
            addCriterion("IMMEDIATE_ARCHIVE not between", value1, value2, "immediateArchive");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeIsNull() {
            addCriterion("TRANSFER_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeIsNotNull() {
            addCriterion("TRANSFER_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeEqualTo(Date value) {
            addCriterion("TRANSFER_DATETIME =", value, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeNotEqualTo(Date value) {
            addCriterion("TRANSFER_DATETIME <>", value, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeGreaterThan(Date value) {
            addCriterion("TRANSFER_DATETIME >", value, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TRANSFER_DATETIME >=", value, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeLessThan(Date value) {
            addCriterion("TRANSFER_DATETIME <", value, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("TRANSFER_DATETIME <=", value, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeIn(List<Date> values) {
            addCriterion("TRANSFER_DATETIME in", values, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeNotIn(List<Date> values) {
            addCriterion("TRANSFER_DATETIME not in", values, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeBetween(Date value1, Date value2) {
            addCriterion("TRANSFER_DATETIME between", value1, value2, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("TRANSFER_DATETIME not between", value1, value2, "transferDatetime");
            return (Criteria) this;
        }

        public Criteria andTransferUserIsNull() {
            addCriterion("TRANSFER_USER is null");
            return (Criteria) this;
        }

        public Criteria andTransferUserIsNotNull() {
            addCriterion("TRANSFER_USER is not null");
            return (Criteria) this;
        }

        public Criteria andTransferUserEqualTo(String value) {
            addCriterion("TRANSFER_USER =", value, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserNotEqualTo(String value) {
            addCriterion("TRANSFER_USER <>", value, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserGreaterThan(String value) {
            addCriterion("TRANSFER_USER >", value, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSFER_USER >=", value, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserLessThan(String value) {
            addCriterion("TRANSFER_USER <", value, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserLessThanOrEqualTo(String value) {
            addCriterion("TRANSFER_USER <=", value, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserLike(String value) {
            addCriterion("TRANSFER_USER like", value, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserNotLike(String value) {
            addCriterion("TRANSFER_USER not like", value, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserIn(List<String> values) {
            addCriterion("TRANSFER_USER in", values, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserNotIn(List<String> values) {
            addCriterion("TRANSFER_USER not in", values, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserBetween(String value1, String value2) {
            addCriterion("TRANSFER_USER between", value1, value2, "transferUser");
            return (Criteria) this;
        }

        public Criteria andTransferUserNotBetween(String value1, String value2) {
            addCriterion("TRANSFER_USER not between", value1, value2, "transferUser");
            return (Criteria) this;
        }

        public Criteria andSnDoneIsNull() {
            addCriterion("SN_DONE is null");
            return (Criteria) this;
        }

        public Criteria andSnDoneIsNotNull() {
            addCriterion("SN_DONE is not null");
            return (Criteria) this;
        }

        public Criteria andSnDoneEqualTo(String value) {
            addCriterion("SN_DONE =", value, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneNotEqualTo(String value) {
            addCriterion("SN_DONE <>", value, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneGreaterThan(String value) {
            addCriterion("SN_DONE >", value, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneGreaterThanOrEqualTo(String value) {
            addCriterion("SN_DONE >=", value, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneLessThan(String value) {
            addCriterion("SN_DONE <", value, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneLessThanOrEqualTo(String value) {
            addCriterion("SN_DONE <=", value, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneLike(String value) {
            addCriterion("SN_DONE like", value, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneNotLike(String value) {
            addCriterion("SN_DONE not like", value, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneIn(List<String> values) {
            addCriterion("SN_DONE in", values, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneNotIn(List<String> values) {
            addCriterion("SN_DONE not in", values, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneBetween(String value1, String value2) {
            addCriterion("SN_DONE between", value1, value2, "snDone");
            return (Criteria) this;
        }

        public Criteria andSnDoneNotBetween(String value1, String value2) {
            addCriterion("SN_DONE not between", value1, value2, "snDone");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdIsNull() {
            addCriterion("AIN_EQUIPMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdIsNotNull() {
            addCriterion("AIN_EQUIPMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdEqualTo(String value) {
            addCriterion("AIN_EQUIPMENT_ID =", value, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdNotEqualTo(String value) {
            addCriterion("AIN_EQUIPMENT_ID <>", value, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdGreaterThan(String value) {
            addCriterion("AIN_EQUIPMENT_ID >", value, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("AIN_EQUIPMENT_ID >=", value, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdLessThan(String value) {
            addCriterion("AIN_EQUIPMENT_ID <", value, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("AIN_EQUIPMENT_ID <=", value, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdLike(String value) {
            addCriterion("AIN_EQUIPMENT_ID like", value, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdNotLike(String value) {
            addCriterion("AIN_EQUIPMENT_ID not like", value, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdIn(List<String> values) {
            addCriterion("AIN_EQUIPMENT_ID in", values, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdNotIn(List<String> values) {
            addCriterion("AIN_EQUIPMENT_ID not in", values, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdBetween(String value1, String value2) {
            addCriterion("AIN_EQUIPMENT_ID between", value1, value2, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andAinEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("AIN_EQUIPMENT_ID not between", value1, value2, "ainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIsNull() {
            addCriterion("CREATED_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIsNotNull() {
            addCriterion("CREATED_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME =", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME <>", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeGreaterThan(Date value) {
            addCriterion("CREATED_DATE_TIME >", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME >=", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeLessThan(Date value) {
            addCriterion("CREATED_DATE_TIME <", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME <=", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIn(List<Date> values) {
            addCriterion("CREATED_DATE_TIME in", values, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotIn(List<Date> values) {
            addCriterion("CREATED_DATE_TIME not in", values, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE_TIME between", value1, value2, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE_TIME not between", value1, value2, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeIsNull() {
            addCriterion("MODIFIED_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeIsNotNull() {
            addCriterion("MODIFIED_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME =", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeNotEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME <>", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeGreaterThan(Date value) {
            addCriterion("MODIFIED_DATE_TIME >", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME >=", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeLessThan(Date value) {
            addCriterion("MODIFIED_DATE_TIME <", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME <=", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeIn(List<Date> values) {
            addCriterion("MODIFIED_DATE_TIME in", values, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeNotIn(List<Date> values) {
            addCriterion("MODIFIED_DATE_TIME not in", values, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFIED_DATE_TIME between", value1, value2, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFIED_DATE_TIME not between", value1, value2, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andPartitionDateIsNull() {
            addCriterion("PARTITION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPartitionDateIsNotNull() {
            addCriterion("PARTITION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPartitionDateEqualTo(Date value) {
            addCriterion("PARTITION_DATE =", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateNotEqualTo(Date value) {
            addCriterion("PARTITION_DATE <>", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateGreaterThan(Date value) {
            addCriterion("PARTITION_DATE >", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("PARTITION_DATE >=", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateLessThan(Date value) {
            addCriterion("PARTITION_DATE <", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateLessThanOrEqualTo(Date value) {
            addCriterion("PARTITION_DATE <=", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateIn(List<Date> values) {
            addCriterion("PARTITION_DATE in", values, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateNotIn(List<Date> values) {
            addCriterion("PARTITION_DATE not in", values, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateBetween(Date value1, Date value2) {
            addCriterion("PARTITION_DATE between", value1, value2, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateNotBetween(Date value1, Date value2) {
            addCriterion("PARTITION_DATE not between", value1, value2, "partitionDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}