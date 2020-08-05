const available = new Vue({
            el: '#forHire',
            data: {
				rows: [],
				currentSort:'',
				currentSortDir:'asc'
			},
					
			mounted() {
				axios.get("http://localhost:8080/listForHire")
					 .then(response => {this.rows = response.data
				})
			},
					
			methods: {
				"sortTable": function
				
				sortTable(col) {
					if(col === this.currentSort) {
						this.currentSortDir = this.currentSortDir==='asc'?'desc':'asc';
					}
					
					this.currentSort = col;
				}
			},
				
			computed: {
				sortedRows:function() {
					return this.rows.sort((a,b) => {
						let modifier = 1;
						if(this.currentSortDir === 'desc') modifier = -1;
						if(a[this.currentSort] < b[this.currentSort]) return -1 * modifier;
						if(a[this.currentSort] > b[this.currentSort]) return 1 * modifier;
						return 0;
					});
				}
			}
		});
				
const hired = new Vue({
			el: '#hired',
			data: {
				rows: [],
				currentSort:'',
				currentSortDir:'asc'
		    },
					
			mounted() {
			    axios.get("http://localhost:8080/listHired")
				     .then(response => {this.rows = response.data
			    })
			},
								
			methods: {
				"sortTable": function
				
				sortTable(col) {
					if(col === this.currentSort) {
						this.currentSortDir = this.currentSortDir==='asc'?'desc':'asc';
					}
					this.currentSort = col;
				}
			},
				
			computed: {
				sortedRows:function() {
					return this.rows.sort((a,b) => {
						let modifier = 1;
						if(this.currentSortDir === 'desc') modifier = -1;
						if(a[this.currentSort] < b[this.currentSort]) return -1 * modifier;
						if(a[this.currentSort] > b[this.currentSort]) return 1 * modifier;
						return 0;
					});
				}
			}
		});