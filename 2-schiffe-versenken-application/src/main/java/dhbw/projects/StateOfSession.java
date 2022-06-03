package dhbw.projects;

public enum StateOfSession {

    WAITING {
        @Override
        boolean isOnAction(){
            return true;
        }

        @Override
        StateOfSession stateOfSession(){
            return stateOfSession().CHOOSING;
        }

    },

    CHOOSING {
        @Override
        boolean isOnAction(){
            return true;
        }

        @Override
        StateOfSession stateOfSession(){
            return stateOfSession().FINISHED;
        }
    },

    FINISHED {
        @Override
        boolean isOnAction(){
            return false;
        }

        @Override
        StateOfSession stateOfSession(){
            return stateOfSession().FINISHED;
        }
    };

    abstract StateOfSession stateOfSession();
    abstract boolean isOnAction();


}

