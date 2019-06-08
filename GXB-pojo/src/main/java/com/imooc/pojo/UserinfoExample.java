package com.imooc.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserinfoExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andUpasswordIsNull() {
            addCriterion("upassword is null");
            return (Criteria) this;
        }

        public Criteria andUpasswordIsNotNull() {
            addCriterion("upassword is not null");
            return (Criteria) this;
        }

        public Criteria andUpasswordEqualTo(String value) {
            addCriterion("upassword =", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotEqualTo(String value) {
            addCriterion("upassword <>", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordGreaterThan(String value) {
            addCriterion("upassword >", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("upassword >=", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLessThan(String value) {
            addCriterion("upassword <", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLessThanOrEqualTo(String value) {
            addCriterion("upassword <=", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLike(String value) {
            addCriterion("upassword like", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotLike(String value) {
            addCriterion("upassword not like", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordIn(List<String> values) {
            addCriterion("upassword in", values, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotIn(List<String> values) {
            addCriterion("upassword not in", values, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordBetween(String value1, String value2) {
            addCriterion("upassword between", value1, value2, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotBetween(String value1, String value2) {
            addCriterion("upassword not between", value1, value2, "upassword");
            return (Criteria) this;
        }

        public Criteria andFaceimageIsNull() {
            addCriterion("faceImage is null");
            return (Criteria) this;
        }

        public Criteria andFaceimageIsNotNull() {
            addCriterion("faceImage is not null");
            return (Criteria) this;
        }

        public Criteria andFaceimageEqualTo(String value) {
            addCriterion("faceImage =", value, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageNotEqualTo(String value) {
            addCriterion("faceImage <>", value, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageGreaterThan(String value) {
            addCriterion("faceImage >", value, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageGreaterThanOrEqualTo(String value) {
            addCriterion("faceImage >=", value, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageLessThan(String value) {
            addCriterion("faceImage <", value, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageLessThanOrEqualTo(String value) {
            addCriterion("faceImage <=", value, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageLike(String value) {
            addCriterion("faceImage like", value, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageNotLike(String value) {
            addCriterion("faceImage not like", value, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageIn(List<String> values) {
            addCriterion("faceImage in", values, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageNotIn(List<String> values) {
            addCriterion("faceImage not in", values, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageBetween(String value1, String value2) {
            addCriterion("faceImage between", value1, value2, "faceimage");
            return (Criteria) this;
        }

        public Criteria andFaceimageNotBetween(String value1, String value2) {
            addCriterion("faceImage not between", value1, value2, "faceimage");
            return (Criteria) this;
        }

        public Criteria andUschoolIsNull() {
            addCriterion("uschool is null");
            return (Criteria) this;
        }

        public Criteria andUschoolIsNotNull() {
            addCriterion("uschool is not null");
            return (Criteria) this;
        }

        public Criteria andUschoolEqualTo(String value) {
            addCriterion("uschool =", value, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolNotEqualTo(String value) {
            addCriterion("uschool <>", value, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolGreaterThan(String value) {
            addCriterion("uschool >", value, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolGreaterThanOrEqualTo(String value) {
            addCriterion("uschool >=", value, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolLessThan(String value) {
            addCriterion("uschool <", value, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolLessThanOrEqualTo(String value) {
            addCriterion("uschool <=", value, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolLike(String value) {
            addCriterion("uschool like", value, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolNotLike(String value) {
            addCriterion("uschool not like", value, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolIn(List<String> values) {
            addCriterion("uschool in", values, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolNotIn(List<String> values) {
            addCriterion("uschool not in", values, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolBetween(String value1, String value2) {
            addCriterion("uschool between", value1, value2, "uschool");
            return (Criteria) this;
        }

        public Criteria andUschoolNotBetween(String value1, String value2) {
            addCriterion("uschool not between", value1, value2, "uschool");
            return (Criteria) this;
        }

        public Criteria andUdepartIsNull() {
            addCriterion("udepart is null");
            return (Criteria) this;
        }

        public Criteria andUdepartIsNotNull() {
            addCriterion("udepart is not null");
            return (Criteria) this;
        }

        public Criteria andUdepartEqualTo(String value) {
            addCriterion("udepart =", value, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartNotEqualTo(String value) {
            addCriterion("udepart <>", value, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartGreaterThan(String value) {
            addCriterion("udepart >", value, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartGreaterThanOrEqualTo(String value) {
            addCriterion("udepart >=", value, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartLessThan(String value) {
            addCriterion("udepart <", value, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartLessThanOrEqualTo(String value) {
            addCriterion("udepart <=", value, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartLike(String value) {
            addCriterion("udepart like", value, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartNotLike(String value) {
            addCriterion("udepart not like", value, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartIn(List<String> values) {
            addCriterion("udepart in", values, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartNotIn(List<String> values) {
            addCriterion("udepart not in", values, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartBetween(String value1, String value2) {
            addCriterion("udepart between", value1, value2, "udepart");
            return (Criteria) this;
        }

        public Criteria andUdepartNotBetween(String value1, String value2) {
            addCriterion("udepart not between", value1, value2, "udepart");
            return (Criteria) this;
        }

        public Criteria andUteleIsNull() {
            addCriterion("utele is null");
            return (Criteria) this;
        }

        public Criteria andUteleIsNotNull() {
            addCriterion("utele is not null");
            return (Criteria) this;
        }

        public Criteria andUteleEqualTo(String value) {
            addCriterion("utele =", value, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleNotEqualTo(String value) {
            addCriterion("utele <>", value, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleGreaterThan(String value) {
            addCriterion("utele >", value, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleGreaterThanOrEqualTo(String value) {
            addCriterion("utele >=", value, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleLessThan(String value) {
            addCriterion("utele <", value, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleLessThanOrEqualTo(String value) {
            addCriterion("utele <=", value, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleLike(String value) {
            addCriterion("utele like", value, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleNotLike(String value) {
            addCriterion("utele not like", value, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleIn(List<String> values) {
            addCriterion("utele in", values, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleNotIn(List<String> values) {
            addCriterion("utele not in", values, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleBetween(String value1, String value2) {
            addCriterion("utele between", value1, value2, "utele");
            return (Criteria) this;
        }

        public Criteria andUteleNotBetween(String value1, String value2) {
            addCriterion("utele not between", value1, value2, "utele");
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