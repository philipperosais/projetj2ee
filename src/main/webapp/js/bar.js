new Chart(document.getElementById("barchart"), {
	type: 'bar',
	data: {
		labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
		datasets: [{
			data: [10,20,30,40,50,60,70,80,25,65,35,55],
			label: 'Dataset 1',
			backgroundColor: "#4755AB",
			borderWidth: 1,
		}, {
			data: [30,10,70,15,30,20,70,80,20,50,60,45],
			label: 'Dataset 2',
			backgroundColor: "#E7EDF6",
			borderWidth: 1,
		}, {
			data: [45,20,30,25,10,80,40,20,55,65,30,70],
			label: 'Dataset 3',
			backgroundColor: "#C3C3C3",
			borderWidth: 1,
		}
	]
	},
	options: {
		responsive: true,
		legend: {
			position: 'top',
		},
	}
});
