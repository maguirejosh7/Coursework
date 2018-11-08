CXX=g++

SRCS=main.cpp CommandLine.cpp
OBJS=$(subst .cpp,.o,$(SRCS))
LDLIBS=-lpthread

all: Shell

Shell: $(OBJS)
	$(CXX) $(LDFLAGS) -o Shell $(OBJS) $(LDLIBS)

clean:
	rm *.o Shell
