package codingforlove.community.Model;

import java.util.ArrayList;
import java.util.List;

public class NotificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotificationExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNotifierIsNull() {
            addCriterion("notifier is null");
            return (Criteria) this;
        }

        public Criteria andNotifierIsNotNull() {
            addCriterion("notifier is not null");
            return (Criteria) this;
        }

        public Criteria andNotifierEqualTo(Long value) {
            addCriterion("notifier =", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotEqualTo(Long value) {
            addCriterion("notifier <>", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierGreaterThan(Long value) {
            addCriterion("notifier >", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierGreaterThanOrEqualTo(Long value) {
            addCriterion("notifier >=", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierLessThan(Long value) {
            addCriterion("notifier <", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierLessThanOrEqualTo(Long value) {
            addCriterion("notifier <=", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierIn(List<Long> values) {
            addCriterion("notifier in", values, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotIn(List<Long> values) {
            addCriterion("notifier not in", values, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierBetween(Long value1, Long value2) {
            addCriterion("notifier between", value1, value2, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotBetween(Long value1, Long value2) {
            addCriterion("notifier not between", value1, value2, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNameIsNull() {
            addCriterion("notifier_name is null");
            return (Criteria) this;
        }

        public Criteria andNotifierNameIsNotNull() {
            addCriterion("notifier_name is not null");
            return (Criteria) this;
        }

        public Criteria andNotifierNameEqualTo(String value) {
            addCriterion("notifier_name =", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameNotEqualTo(String value) {
            addCriterion("notifier_name <>", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameGreaterThan(String value) {
            addCriterion("notifier_name >", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameGreaterThanOrEqualTo(String value) {
            addCriterion("notifier_name >=", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameLessThan(String value) {
            addCriterion("notifier_name <", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameLessThanOrEqualTo(String value) {
            addCriterion("notifier_name <=", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameLike(String value) {
            addCriterion("notifier_name like", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameNotLike(String value) {
            addCriterion("notifier_name not like", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameIn(List<String> values) {
            addCriterion("notifier_name in", values, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameNotIn(List<String> values) {
            addCriterion("notifier_name not in", values, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameBetween(String value1, String value2) {
            addCriterion("notifier_name between", value1, value2, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameNotBetween(String value1, String value2) {
            addCriterion("notifier_name not between", value1, value2, "notifierName");
            return (Criteria) this;
        }

        public Criteria andOuteridIsNull() {
            addCriterion("outerId is null");
            return (Criteria) this;
        }

        public Criteria andOuteridIsNotNull() {
            addCriterion("outerId is not null");
            return (Criteria) this;
        }

        public Criteria andOuteridEqualTo(Long value) {
            addCriterion("outerId =", value, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuteridNotEqualTo(Long value) {
            addCriterion("outerId <>", value, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuteridGreaterThan(Long value) {
            addCriterion("outerId >", value, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuteridGreaterThanOrEqualTo(Long value) {
            addCriterion("outerId >=", value, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuteridLessThan(Long value) {
            addCriterion("outerId <", value, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuteridLessThanOrEqualTo(Long value) {
            addCriterion("outerId <=", value, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuteridIn(List<Long> values) {
            addCriterion("outerId in", values, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuteridNotIn(List<Long> values) {
            addCriterion("outerId not in", values, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuteridBetween(Long value1, Long value2) {
            addCriterion("outerId between", value1, value2, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuteridNotBetween(Long value1, Long value2) {
            addCriterion("outerId not between", value1, value2, "outerid");
            return (Criteria) this;
        }

        public Criteria andOuterTitleIsNull() {
            addCriterion("outer_title is null");
            return (Criteria) this;
        }

        public Criteria andOuterTitleIsNotNull() {
            addCriterion("outer_title is not null");
            return (Criteria) this;
        }

        public Criteria andOuterTitleEqualTo(String value) {
            addCriterion("outer_title =", value, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleNotEqualTo(String value) {
            addCriterion("outer_title <>", value, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleGreaterThan(String value) {
            addCriterion("outer_title >", value, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleGreaterThanOrEqualTo(String value) {
            addCriterion("outer_title >=", value, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleLessThan(String value) {
            addCriterion("outer_title <", value, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleLessThanOrEqualTo(String value) {
            addCriterion("outer_title <=", value, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleLike(String value) {
            addCriterion("outer_title like", value, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleNotLike(String value) {
            addCriterion("outer_title not like", value, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleIn(List<String> values) {
            addCriterion("outer_title in", values, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleNotIn(List<String> values) {
            addCriterion("outer_title not in", values, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleBetween(String value1, String value2) {
            addCriterion("outer_title between", value1, value2, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andOuterTitleNotBetween(String value1, String value2) {
            addCriterion("outer_title not between", value1, value2, "outerTitle");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Long value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Long value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Long value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Long value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Long value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Long> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Long> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Long value1, Long value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Long value1, Long value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(Long value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(Long value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(Long value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(Long value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(Long value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<Long> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<Long> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(Long value1, Long value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(Long value1, Long value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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