#include<iostream>
#include<vector>
#include<queue>
using std::cin;
using std::cout;
using std::vector;
using std::endl;
using std::queue;

int st[50][50][50][50];
int x, y, bx, by, tx, ty;
int m, n;
vector<vector<char>> mm;

bool valid(int x, int y) {
	//cout <<m<<" "<<n<<"-"<<endl;
	if (x >= 0 && x<m&&y >= 0 && y<n&&mm[x][y] != '#')return true;
	return false;
}

int main() {

	cin >> m >> n;
	mm = vector<vector<char>>(m, vector<char>(n, ' '));

	for (int i = 0; i < m; i++)
		for (int j = 0; j< n; j++)
		{
			char t;
			cin >> t;
			if (t == 'S') {
				x = i; y = j;
			}
			if (t == '0') {
				bx = i; by = j;
			}
			if (t == 'E') {
				tx = i; ty = j;
			}
			mm[i][j] = t;
		}

	vector<vector<int>> next = { { -1, 0 },{ 1,0 },{ 0,1 },{ 0,-1 } };
	queue<vector<int>> que;
	que.push({ x,y,bx,by });

	st[x][y][bx][by] = 1;
	while (!que.empty())
	{
		vector<int> t = que.front();
		que.pop();
		x = t[0];  y = t[1];  bx = t[2]; by = t[3];
		for (int i = 0; i < next.size(); i++)
		{
			int nx = x + next[i][0], ny = y + next[i][1];
			int nnx = nx + next[i][0], nny = ny + next[i][1];
			if (valid(nx, ny) && (nx != bx || ny != by) && st[nx][ny][bx][by] == 0)
			{
				st[nx][ny][bx][by] = st[x][y][bx][by] + 1;
				que.push({ nx,ny,bx,by });
				continue;

			}
			else if (nx == bx&&ny == by&&valid(nnx, nny) && st[nx][ny][nnx][nny] == 0) {
				st[nx][ny][nnx][nny] = st[x][y][bx][by] + 1;
				if (mm[nnx][nny] == 'E') { cout << st[nx][ny][nnx][nny] - 1; return 0; }
				que.push({ nx,ny,nnx,nny });
			}
		}
	}

	cout << -1;
	return 0;
}
