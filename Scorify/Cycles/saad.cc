
#include <cstdio>
#include <cstring>
#include <vector>
#include <iostream>

using namespace std;

const int N = 1000010;
int n, m;

struct Edge {
    int x, y;

    Edge() {}

    Edge(int x_, int y_):
        x(x_), y(y_) {}
};

vector<Edge> adj[N];
int in[N], out[N];
int seen[N];
int t; /* Current time */

/* Is x an ancestor of y in DFS tree */
bool isAncector(int x, int y) {
    return (in[x] < in[y] && out[y] < out[x]);
}

bool isBackEdge(int x, int y) {
    return isAncector(y, x);
}

int listBackEdges(void) {
    int count = 0;
    for(int i = 0; i < n; i++)
        for(auto e: adj[i]) if(isBackEdge(i, e.y))
            count += 1;
    return count;
}

void dfs(int x) {
    in[x] = t++;
    seen[x] = 1;
    for(auto e: adj[x])
        if(seen[e.y] == 0)
            dfs(e.y);
    out[x] = t++;
}

int main( void ) {


    while(cin >> n >> m) {
		for(int i = 0; i < n; i++)
			adj[i].clear();

	    for(int i = 0; i < m; i++) {
			int x, y;

			cin >> x >> y;
			adj[x].push_back(Edge(x, y));
	    }

		t = 0;
		memset(seen, 0, sizeof(seen));

		for(int i = 0; i < n; i++)
			if(seen[i] == 0)
			    dfs(0);

	    cout << listBackEdges() << endl;
    }

    return 0;
}

