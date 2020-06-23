package iwehdio.save;

public class saveFunction {
    /*
public List<Integer> findForward(Integer size, boolean type) {
        Integer maxLength = 0;
        Integer start = 0;
        boolean flag = false;
        if(type) {
            for (int i = 0; i < field.size(); i++) {
                if (field.get(i)) {
                    maxLength += 1;
                } else {
                    maxLength = 0;
                    start = i+1;
                }
                if (maxLength == size) {
                    flag = true;
                    break;
                }
            }
        } else {
            Integer saveMaxLength = 0;
            Integer saveStart = 0;
            for (int i = 0; i < field.size(); i++) {
                if (field.get(i)) {
                    maxLength += 1;
                } else {
                    if(saveMaxLength<maxLength) {
                        saveMaxLength = maxLength;
                        saveStart = start;
                    }
                    maxLength = 0;
                    start = i+1;
                }
                if (maxLength == size) {
                    flag = true;
                    break;
                }
            }
            if(saveMaxLength<maxLength) {
                saveMaxLength = maxLength;
                saveStart = start;
            }
            maxLength = saveMaxLength;
            start = saveStart;
            flag = true;
        }
        if(start>=0 && start<field.size() && flag) {
            for(int i=0; i<maxLength; i++) {
                field.set(i+start, false);
            }
        } else {
            return null;
        }
        List<Integer> res = new ArrayList<Integer>();
        res.add(start);
        res.add(start + maxLength - 1);
        return res;
    }

    public List<Integer> findPoint(Integer size, boolean type, Integer point) {
        Integer maxLength = 0;
        Integer start = point;
        boolean flag = false;
        if(type) {
            for (int i = point; i < field.size(); i++) {
                if (field.get(i)) {
                    maxLength += 1;
                } else {
                    maxLength = 0;
                    start = i+1;
                }
                if (maxLength == size) {
                    flag = true;
                    break;
                }
            }
        } else {
            Integer saveMaxLength = 0;
            Integer saveStart = point;
            for (int i = point; i < field.size(); i++) {
                if (field.get(i)) {
                    maxLength += 1;
                } else {
                    if(saveMaxLength<maxLength) {
                        saveMaxLength = maxLength;
                        saveStart = start;
                    }
                    maxLength = 0;
                    start = i+1;
                }
                if (maxLength == size) {
                    flag = true;
                    break;
                }
            }
            if(saveMaxLength<maxLength) {
                saveMaxLength = maxLength;
                saveStart = start;
            }
            maxLength = saveMaxLength;
            start = saveStart;
            flag = true;
        }
        if(start>=point && start<field.size() && flag) {
            for(int i=0; i<maxLength; i++) {
                field.set(i+start, false);
            }
        } else {
            return null;
        }
        List<Integer> res = new ArrayList<Integer>();
        res.add(start);
        res.add(start + maxLength - 1);
        return res;
    }


    public List<Integer> findReverse(Integer size, boolean type) {
        Integer maxLength = 0;
        Integer last = field.size() - 1;
        boolean flag = false;
        if (type) {
            for (int i = field.size() - 1; i >= 0; i--) {
                if (field.get(i)) {
                    maxLength += 1;
                } else {
                    maxLength = 0;
                    last = i - 1;
                }
                if (maxLength == size) {
                    flag = true;
                    break;
                }
            }
        } else {
            Integer saveMaxLength = 0;
            Integer savelast = field.size() - 1;
            for (int i = field.size() - 1; i >= 0; i--) {
                if (field.get(i)) {
                    maxLength += 1;
                } else {
                    if (saveMaxLength < maxLength) {
                        saveMaxLength = maxLength;
                        savelast = last;
                    }
                    maxLength = 0;
                    last = i - 1;
                }
                if (maxLength == size) {
                    flag = true;
                    break;
                }
            }
            if (saveMaxLength < maxLength) {
                saveMaxLength = maxLength;
                savelast = last;
            }
            maxLength = saveMaxLength;
            last = savelast;
            flag = true;
        }
        if (last >= 0 && last < field.size() && flag) {
            for (int i = 0; i < maxLength; i++) {
                field.set(last - i, false);
            }
        } else {
            return null;
        }
        List<Integer> res = new ArrayList<Integer>();
        res.add(last - maxLength + 1);
        res.add(last);
        return res;
    }


    public List<Integer> findRange(Integer size, boolean type, Integer header, Integer trailer) {
        Integer maxLength = 0;
        Integer start = header;
        boolean flag = false;
        if (type) {
            for (int i = header; i < trailer; i++) {
                if (field.get(i)) {
                    maxLength += 1;
                } else {
                    maxLength = 0;
                    start = i + 1;
                }
                if (maxLength == size) {
                    flag = true;
                    break;
                }
            }
        } else {
            Integer saveMaxLength = 0;
            Integer saveStart = header;
            for (int i = header; i < trailer; i++) {
                if (field.get(i)) {
                    maxLength += 1;
                } else {
                    if (saveMaxLength < maxLength) {
                        saveMaxLength = maxLength;
                        saveStart = start;
                    }
                    maxLength = 0;
                    start = i + 1;
                }
                if (maxLength == size) {
                    flag = true;
                    break;
                }
            }
            if (saveMaxLength < maxLength) {
                saveMaxLength = maxLength;
                saveStart = start;
            }
            maxLength = saveMaxLength;
            start = saveStart;
            flag = true;
        }
        if (start >= header && start < trailer && flag) {
            for (int i = 0; i < maxLength; i++) {
                field.set(i + start, false);
            }
        } else {
            return null;
        }
        List<Integer> res = new ArrayList<Integer>();
        res.add(start);
        res.add(start + maxLength - 1);
        return res;
    }
     */
}
